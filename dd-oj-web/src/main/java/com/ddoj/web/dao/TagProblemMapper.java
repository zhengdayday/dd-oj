package com.ddoj.web.dao;

import com.ddoj.web.entity.TagProblemEntity;
import com.ddoj.web.entity.TagProblemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhengtt
 **/
@Repository
public interface TagProblemMapper {
    int save(TagProblemEntity tagProblemEntity);

    List<TagProblemEntity> listByPid(int pid);

    int deleteByPid(int pid);

    int countByTid(int tid);
}
