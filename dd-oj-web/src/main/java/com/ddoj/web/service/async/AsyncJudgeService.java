package com.ddoj.web.service.async;

import com.ddoj.judge.LanguageEnum;
import com.ddoj.web.entity.TestCaseEntity;

import java.util.List;

/**
 * @author zhengtt
 **/
public interface AsyncJudgeService {
    String addTestJudge(String sourceCode, LanguageEnum lang, int time, int memory,
                        List<TestCaseEntity> testCases);

    String addProblemJudge(String sourceCode, LanguageEnum lang,
                           int owner, int pid);

    String addContestJudge(String sourceCode, LanguageEnum lang,
                           int owner, int pid,
                           int cid);

    String addGroupJudge(String sourceCode, LanguageEnum lang,
                         int owner, int pid,
                         int cid,
                         int gid);
}
