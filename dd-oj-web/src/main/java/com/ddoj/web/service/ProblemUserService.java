package com.ddoj.web.service;

import com.ddoj.judge.ResultEnum;
import com.ddoj.web.entity.ProblemUserEntity;

import java.util.List;
import java.util.Map;

/**
 * @author zhengtt
 **/
public interface ProblemUserService {

    void save(int pid, int uid, ResultEnum status);

    ProblemUserEntity get(int pid, int uid);

    List<Map<String, Object>> listUserProblemHistory(int uid);

    void updateByPidUid(int pid, int uid, ResultEnum result);
}
