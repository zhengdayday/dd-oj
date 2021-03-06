package com.ddoj.web.service;

import com.ddoj.web.data.status.ContestStatus;
import com.ddoj.web.entity.ContestEntity;

import java.util.List;
import java.util.Map;

/**
 * @author zhengtt
 **/
public interface ContestService {

    int saveContest(String name, int owner, int group, String slogan, String description,
                   long startTime, long endTime, Long totalTime, String password,
                   int type);

    int countGroupContests(int gid);

    int countContests();

    void deleteContest(int cid);

    ContestEntity getContest(int cid);


    void updateContest(int cid, String name, String slogan, String description, long startTime,
                      long endTime, Long totalTime, String password, int type, int status);

    List<Map<String, Object>> listOpenedContests();

    List<Map<String, Object>> listAllContests();

    List<ContestEntity> listGroupContests(int gid, ContestStatus status);

    List<ContestEntity> listUserContests(int uid, int gid);
}
