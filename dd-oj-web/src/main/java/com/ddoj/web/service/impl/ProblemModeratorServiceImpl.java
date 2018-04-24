package com.ddoj.web.service.impl;

import com.ddoj.web.security.SessionHelper;
import com.ddoj.web.controller.exception.WebErrorException;
import com.ddoj.web.dao.ProblemModeratorMapper;
import com.ddoj.web.entity.ProblemModeratorEntity;
import com.ddoj.web.entity.UserEntity;
import com.ddoj.web.security.SessionHelper;
import com.ddoj.web.service.ProblemModeratorService;
import com.ddoj.web.service.UserService;
import com.ddoj.web.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zhengtt
 **/
@Service
public class ProblemModeratorServiceImpl implements ProblemModeratorService {

    @Autowired
    private ProblemModeratorMapper problemModeratorMapper;

    @Autowired
    private UserService userService;

    @Override
    public void addProblemModerator(int pid, String email) {
        UserEntity userEntity = userService.getUserByEmail(email);
        int uid = userEntity.getUid();
        if (uid == SessionHelper.get().getUid()) {
            throw new WebErrorException("不能添加自己");
        }
        if (problemModeratorMapper.getByPidUid(pid, uid) != null) {
            throw new WebErrorException("已经存在此用户");
        }
        ProblemModeratorEntity problemModeratorEntity = new ProblemModeratorEntity();
        problemModeratorEntity.setPid(pid);
        problemModeratorEntity.setUid(uid);
        boolean flag = problemModeratorMapper.save(problemModeratorEntity) == 1;
        WebUtil.assertIsSuccess(flag, "添加用户失败");
    }

    @Override
    public int countProblemModerators(int pid) {
        return problemModeratorMapper.countByPid(pid);
    }

    @Override
    public List<Map<String, Object>> listProblemModerators(int pid) {
        return problemModeratorMapper.listModeratorsByPid(pid);
    }

    @Override
    public void deleteModerator(int pid, int uid) {
        boolean flag = problemModeratorMapper.deleteByPidUid(pid, uid) == 1;
        WebUtil.assertIsSuccess(flag, "删除用户失败");
    }

    @Override
    public void deleteModerators(int pid) {
        boolean flag = problemModeratorMapper.deleteByPid(pid) > 0;
        WebUtil.assertIsSuccess(flag, "删除题目维护者失败");
    }

    @Override
    public boolean isExistModeratorInProblem(int pid, int uid) {
        return problemModeratorMapper.getByPidUid(pid, uid) != null;
    }
}
