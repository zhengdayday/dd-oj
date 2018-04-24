package com.ddoj.web.service;

import com.ddoj.web.entity.TestCaseEntity;

import java.util.List;

/**
 * @author zhengtt
 **/
public interface TestCasesService {
    int save(int pid, String stdin, String stdout, int strength);

    int countProblemTestCases(int pid);

    List<TestCaseEntity> listProblemTestCases(int pid);

    void updateTestCaseByTidPid(int tid, int pid, String stdin, String stdout, int strength);

    void deleteTestCase(int tid, int pid);

    void deleteProblemTestCases(int pid);
}
