package com.ddoj.web.service.impl;

import com.ddoj.judge.LanguageEnum;
import com.ddoj.judge.ResultEnum;
import com.ddoj.web.dao.SubmissionMapper;
import com.ddoj.web.entity.SubmissionEntity;
import com.ddoj.web.service.SubmissionService;
import com.ddoj.web.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zhengtt
 **/
@Service
public class SubmissionServiceImpl implements SubmissionService {

    @Autowired
    private SubmissionMapper submissionMapper;

    @Override
    public void save(int owner, int pid, int cid, int gid, int sourceCode, LanguageEnum lang, double time, int memory,
                   ResultEnum status) {
        SubmissionEntity submissionEntity = new SubmissionEntity();
        submissionEntity.setOwner(owner);
        submissionEntity.setPid(pid);
        submissionEntity.setCid(cid);
        submissionEntity.setGid(gid);
        submissionEntity.setSourceCode(sourceCode);
        submissionEntity.setLang(lang);
        submissionEntity.setTime(time);
        submissionEntity.setMemory(memory);
        submissionEntity.setStatus(status);
        submissionEntity.setSubmitTime(System.currentTimeMillis());
        boolean flag = submissionMapper.save(submissionEntity) == 1;
        WebUtil.assertIsSuccess(flag, "代码提交记录保存失败");
    }

    @Override
    public int countProblemSubmissions(int pid) {
        return submissionMapper.countByPid(pid);
    }

    @Override
    public List<Map<String, Object>> listOwnSubmissions(Integer owner, Integer pid, Integer cid) {
        return submissionMapper.listSubmissionsByOwnerPidCid(owner, pid, cid);
    }

    @Override
    public List<Map<String, Object>> listProblemSubmissions(Integer pid, Integer cid) {
        return submissionMapper.listSubmissionsByOwnerPidCid(null, pid, cid);
    }
}
