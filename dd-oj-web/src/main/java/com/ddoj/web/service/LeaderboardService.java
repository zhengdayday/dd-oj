package com.ddoj.web.service;

import com.ddoj.web.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * @author zhengtt
 **/
public interface LeaderboardService {

    void refreshContestLeaderboard(int cid);

    List<Map<String, Object>> getContestLeaderboard(int cid);

    Map<String, Object> getUserMetaInContest(int uid, int cid);

    List<UserEntity> getLeaderboard();

    List<Map<String, Object>> getUserDetailInContest(int cid, int uid);
}
