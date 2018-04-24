package com.ddoj.web.dao;

import com.ddoj.web.entity.TagEntity;
import com.ddoj.web.entity.TagEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhengtt
 **/
@Repository
public interface TagsMapper {

    int save(TagEntity tagEntity);

    TagEntity getByName(String name);

    int deleteByTid(int tid);

    List<TagEntity> listAll();

    int updateByTid(@Param("tid") int tid, @Param("data") TagEntity data);
}
