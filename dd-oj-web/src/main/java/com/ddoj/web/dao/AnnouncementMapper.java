package com.ddoj.web.dao;

import com.ddoj.web.entity.AnnouncementEntity;
import com.ddoj.web.entity.AnnouncementEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhengtt
 **/
@Repository
public interface AnnouncementMapper {
    int save(AnnouncementEntity data);

    List<AnnouncementEntity> listAll();

    int deleteByAid(int aid);

    int updateByAid(@Param("aid") int aid, @Param("data") AnnouncementEntity data);
}
