package com.ddoj.web.service;

import com.ddoj.web.entity.ContestUserEntity;

import java.util.List;
import java.util.Map;

/**
 * @author zhengtt
 **/
public interface ContestUserService {

    ContestUserEntity get(int cid, int uid);

    int countContestUsers(int cid);

    List<Map<String, Object>> listUserJoinedContests(int uid);

    void updateByCidUid(int cid, int uid, ContestUserEntity entity);

    void joinContest(int cid, int uid, String password);
}
