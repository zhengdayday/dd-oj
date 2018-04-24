package com.ddoj.web.service;

import com.ddoj.web.entity.JudgerEntity;

import java.util.List;

/**
 * @author zhengtt
 **/
public interface JudgerService {
    List<JudgerEntity> listJudger();

    void addJudger(String url, int port);

    void deleteJudger(int jid);

    void updateJudger(int jid, String url, Integer port);
}
