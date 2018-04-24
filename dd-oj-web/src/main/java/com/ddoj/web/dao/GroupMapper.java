package com.ddoj.web.dao;

import com.ddoj.web.entity.GroupEntity;
import com.ddoj.web.entity.GroupEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhengtt
 **/
@Repository
public interface GroupMapper {
    int save(GroupEntity groupEntity);

    int count();

    GroupEntity getGroupByGid(int gid);

    List<GroupEntity> listGroupsByOwner(int owner);

    List<GroupEntity> listAll();

    int updateByGid(@Param("gid") int gid, @Param("data") GroupEntity data);

    int deleteByGid(int gid);
}
