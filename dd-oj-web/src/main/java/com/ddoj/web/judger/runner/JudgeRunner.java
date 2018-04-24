package com.ddoj.web.judger.runner;

import com.ddoj.judge.LanguageEnum;
import com.ddoj.judge.ResultEnum;
import com.ddoj.judge.entity.RequestEntity;
import com.ddoj.judge.entity.ResponseEntity;
import com.ddoj.judge.entity.TestCaseRequestEntity;
import com.ddoj.judge.judger.Judger;
import com.ddoj.judge.judger.dayday.Dayday;
import com.ddoj.web.service.JudgeService;
import com.ddoj.web.cache.CacheController;
import com.ddoj.web.entity.TestCaseEntity;
import com.ddoj.web.judger.JudgeQueue;
import com.ddoj.web.judger.JudgeResult;
import com.ddoj.web.judger.JudgeStatus;
import com.ddoj.web.judger.JudgerDispatcher;
import com.ddoj.web.judger.task.*;
import com.ddoj.web.service.JudgeService;
import org.ehcache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhengtt
 **/
@Component
public class JudgeRunner {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final int MAX_THREADS = 3;

    private final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(MAX_THREADS);

    private final Cache<String, JudgeResult> submissionCache = CacheController.getSubmissionCache();

    private JudgeService judgeService;

    private JudgerDispatcher judgerDispatcher;

    public JudgeRunner(JudgeQueue queue,
                       JudgeService judgeService,
                       JudgerDispatcher judgerDispatcher) {
        this.judgeService = judgeService;
        this.judgerDispatcher = judgerDispatcher;
        new Thread(() -> {
            while (true) {
                JudgeTask judgeTask = queue.take();
                try {
                    THREAD_POOL.execute(new Runner(judgeTask));
                } catch (Exception e) {
                    submissionCache.get(judgeTask.getId()).setStatus(JudgeStatus.Error);
                    LOGGER.error(e.getMessage());
                }
            }
        }).start();
    }

    class Runner implements Runnable {

        private JudgeTask judgeTask;

        private JudgeResult judgeResult;

        Runner(JudgeTask task) {
            this.judgeTask = task;
            this.judgeResult = submissionCache.get(judgeTask.getId());
        }

        @Override
        public void run() {
            // 正在判卷
            judgeResult.setStatus(JudgeStatus.Judging);

            LanguageEnum lang = judgeTask.getLang();
            String sourceCode = judgeTask.getSourceCode();
            int time = judgeTask.getTime();
            int memory =judgeTask.getMemory();
            List<TestCaseRequestEntity> testCases = new ArrayList<>(judgeTask.getTestCases().size());
            for (TestCaseEntity entity: judgeTask.getTestCases()) {
                TestCaseRequestEntity requestEntity = new TestCaseRequestEntity(entity.getStdin(), entity.getStdout());
                testCases.add(requestEntity);
            }
            RequestEntity requestEntity = new RequestEntity(lang, sourceCode, time, memory, testCases);
            String judgerUrl = judgerDispatcher.getJudgerUrl();
            if (judgerUrl == null) {
                setJudgeFailed();
                LOGGER.error("判卷地址不得为空");
                return;
            }
            Judger judger = new Judger(judgerUrl, requestEntity, new Dayday());
            ResponseEntity responseEntity = judger.judge();
            if (responseEntity.getResult() == ResultEnum.SE) {
                setJudgeFailed();
                judgeResult.setResponse(responseEntity);
                return;
            }
            judgeResult.setResponse(responseEntity);
            save();
        }

        private void save() {
            // 正在保存
            judgeResult.setStatus(JudgeStatus.Saving);

            if (judgeTask instanceof GroupJudgeTask) {
                LOGGER.info("Saving group");
                judgeService.saveGroupContestCode((GroupJudgeTask) judgeTask, judgeResult.getResponse());
            } else if (judgeTask instanceof ContestJudgeTask) {
                LOGGER.info("Saving contest");
                judgeService.saveContestCode((ContestJudgeTask) judgeTask, judgeResult.getResponse());
            } else if (judgeTask instanceof ProblemJudgeTask) {
                LOGGER.info("Saving problem");
                judgeService.saveProblemCode((ProblemJudgeTask) judgeTask, judgeResult.getResponse());
            } else {
                // do nothing
                LOGGER.info("Saving test");
            }
            judgeResult.setStatus(JudgeStatus.Finished);
        }

        private void setJudgeFailed() {
            judgeResult.setStatus(JudgeStatus.Error);
        }
    }
}
