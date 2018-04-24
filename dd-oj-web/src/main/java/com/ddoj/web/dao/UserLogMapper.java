package com.ddoj.web.dao;

import com.ddoj.web.entity.UserLogEntity;
import com.ddoj.web.entity.UserLogEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhengtt
 **/
@Repository
public interface UserLogMapper {
    int saveByUid(@Param("uid") int uid, @Param("data") UserLogEntity userLogEntity);

    List<UserLogEntity> listInWeekByUid(int uid);

    List<UserLogEntity> listInMonthByUid(int uid);
}
