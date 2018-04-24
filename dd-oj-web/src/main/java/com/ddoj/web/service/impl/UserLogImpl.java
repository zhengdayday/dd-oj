package com.ddoj.web.service.impl;

import com.ddoj.web.dao.UserLogMapper;
import com.ddoj.web.entity.UserLogEntity;
import com.ddoj.web.service.UserLogService;
import com.ddoj.web.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhengtt
 **/
@Service
public class UserLogImpl implements UserLogService {

    @Autowired
    private UserLogMapper userLogMapper;

    @Override
    public void save(int uid, UserLogEntity entity) {
        boolean flag = userLogMapper.saveByUid(uid, entity) > 0;
        WebUtil.assertIsSuccess(flag, "用户提交记录保存失败");
    }

    @Override
    public List<UserLogEntity> listUserLogInWeek(int uid) {
        return userLogMapper.listInWeekByUid(uid);
    }

    @Override
    public List<UserLogEntity> listUserLogInMonth(int uid) {
        return userLogMapper.listInMonthByUid(uid);
    }
}
