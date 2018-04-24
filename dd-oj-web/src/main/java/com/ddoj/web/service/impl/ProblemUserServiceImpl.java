package com.ddoj.web.service.impl;

import com.ddoj.judge.ResultEnum;
import com.ddoj.web.dao.ProblemUserMapper;
import com.ddoj.web.entity.ProblemUserEntity;
import com.ddoj.web.service.ProblemUserService;
import com.ddoj.web.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zhengtt
 **/
@Service
public class ProblemUserServiceImpl implements ProblemUserService {

    @Autowired
    private ProblemUserMapper problemUserMapper;

    @Override
    public void save(int pid, int uid, ResultEnum status) {
        ProblemUserEntity problemUserEntity = new ProblemUserEntity();
        problemUserEntity.setPid(pid);
        problemUserEntity.setUid(uid);
        problemUserEntity.setStatus(status);
        boolean flag = problemUserMapper.save(problemUserEntity) == 1;
        WebUtil.assertIsSuccess(flag, "用户做题记录保存失败");
    }

    @Override
    public ProblemUserEntity get(int pid, int uid) {
        ProblemUserEntity problemUserEntity = problemUserMapper.getByPidUid(pid, uid);
        WebUtil.assertNotNull(problemUserEntity, "没有该记录");
        return problemUserEntity;
    }

    @Override
    public List<Map<String, Object>> listUserProblemHistory(int uid) {
        return problemUserMapper.listUserProblemsByUid(uid);
    }

    @Override
    public void updateByPidUid(int pid, int uid, ResultEnum result) {
        ProblemUserEntity problemUserEntity = new ProblemUserEntity();
        problemUserEntity.setStatus(result);
        boolean flag =  problemUserMapper.updateByPidUid(pid, uid, problemUserEntity) == 1;
        WebUtil.assertIsSuccess(flag, "用户做题记录更新失败");
    }
}
