package com.ddoj.web.dao;

import com.ddoj.web.entity.SettingEntity;
import com.ddoj.web.entity.SettingEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhengtt
 **/
@Repository
public interface SettingMapper {

    int save(SettingEntity entity);

    int saveList(List<SettingEntity> entities);

    SettingEntity getByKey(String key);

    List<SettingEntity> listByKeys(List<String> keys);
}
