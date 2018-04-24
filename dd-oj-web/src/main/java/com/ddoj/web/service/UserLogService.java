package com.ddoj.web.service;

import com.ddoj.web.entity.UserLogEntity;

import java.util.List;

/**
 * @author zhengtt
 **/
public interface UserLogService {

    void save(int uid, UserLogEntity entity);

    List<UserLogEntity> listUserLogInWeek(int uid);

    List<UserLogEntity> listUserLogInMonth(int uid);
}
