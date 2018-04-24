package com.ddoj.web.service;

import com.ddoj.judge.ResultEnum;
import com.ddoj.web.entity.ContestProblemUserEntity;

import java.util.List;
import java.util.Map;

/**
 * @author zhengtt
 **/
public interface ContestProblemUserService {

    ContestProblemUserEntity getByCidPidUid(int cid, int pid, int uid);

    List<ContestProblemUserEntity> listAllByCid(int cid);

    List<Map<String, Object>> listUserDetailInContest(int cid, int uid);

    void save(int cid, int pid, int uid, int score,
                 ResultEnum status, long solvedTimes, long usedTime);

    boolean update(int cid, int pid, int uid, int score, ResultEnum status,
                   long solvedTime, long usedTime);

}
