package com.ddoj.web.judger.task;

import com.ddoj.judge.LanguageEnum;
import com.ddoj.web.entity.TestCaseEntity;

import java.util.List;

/**
 * @author zhengtt
 **/
public interface JudgeTask {
    String getId();

    String getSourceCode();

    LanguageEnum getLang();

    List<TestCaseEntity> getTestCases();

    int getTime();

    int getMemory();

    int getPriority();

}
