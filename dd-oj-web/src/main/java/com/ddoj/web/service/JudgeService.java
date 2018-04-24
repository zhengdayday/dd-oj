package com.ddoj.web.service;

import com.ddoj.judge.entity.ResponseEntity;
import com.ddoj.web.judger.JudgeResult;
import com.ddoj.web.judger.task.ContestJudgeTask;
import com.ddoj.web.judger.task.GroupJudgeTask;
import com.ddoj.web.judger.task.ProblemJudgeTask;

/**
 * @author zhengtt
 **/
public interface JudgeService {

    JudgeResult getJudgeResult(String id);

    void saveProblemCode(ProblemJudgeTask task, ResponseEntity response);

    void saveContestCode(ContestJudgeTask task, ResponseEntity response);

    void saveGroupContestCode(GroupJudgeTask task, ResponseEntity response);

}
