package com.ddoj.web.service.impl;

import com.ddoj.web.controller.exception.WebErrorException;
import com.ddoj.web.dao.TestCasesMapper;
import com.ddoj.web.entity.TestCaseEntity;
import com.ddoj.web.service.TestCasesService;
import com.ddoj.web.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhengtt
 **/
@Service
public class TestCasesServiceImpl implements TestCasesService {

    @Autowired
    private TestCasesMapper testCasesMapper;

    @Override
    public int save(int pid, String stdin, String stdout, int strength) {
        // 添加一个TestCase
        TestCaseEntity testCaseEntity = new TestCaseEntity();
        testCaseEntity.setPid(pid);
        testCaseEntity.setStdin(stdin);
        testCaseEntity.setStdout(stdout);
        testCaseEntity.setStrength(strength);
        testCaseEntity.setCreateTime(System.currentTimeMillis());
        boolean flag = testCasesMapper.save(testCaseEntity) == 1;
        WebUtil.assertIsSuccess(flag, "测试用例保存失败");
        return testCaseEntity.getTid();
    }

    @Override
    public int countProblemTestCases(int pid) {
        return testCasesMapper.countByPid(pid);
    }

    @Override
    public List<TestCaseEntity> listProblemTestCases(int pid){
        //通过pid来查询所有的TestCase
        return testCasesMapper.listTestCasesByPid(pid);
    }

    @Override
    public void updateTestCaseByTidPid(int tid, int pid, String stdin, String stdout, int strength) {
        //通过TestCase的ID来修改TestCase
        TestCaseEntity testCaseEntity = new TestCaseEntity();
        testCaseEntity.setStdin(stdin);
        testCaseEntity.setStdout(stdout);
        testCaseEntity.setStrength(strength);

        boolean flag = testCasesMapper.updateByTidPid(tid, pid, testCaseEntity) == 1;
        WebUtil.assertIsSuccess(flag, "测试用例更新失败");
    }

    @Override
    public void deleteTestCase(int tid, int pid) {
        WebUtil.assertIsSuccess(testCasesMapper.deleteByTidPid(tid, pid) == 1, "测试用例删除失败");
    }

    @Override
    public void deleteProblemTestCases(int pid) {
        boolean flag = testCasesMapper.deleteByPid(pid) > 0;
        WebUtil.assertIsSuccess(flag, "测试用例删除失败");
    }
}
