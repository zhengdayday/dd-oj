package com.ddoj.web.dao;

import com.ddoj.web.entity.ProblemModeratorEntity;
import com.ddoj.web.entity.ProblemModeratorEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author zhengtt
 **/
@Repository
public interface ProblemModeratorMapper {
    int save(ProblemModeratorEntity problemModeratorEntity);

    int countByPid(int pid);

    ProblemModeratorEntity getByPidUid(@Param("pid") int pid,
                                       @Param("uid") int uid);

    List<Map<String, Object>> listModeratorsByPid(int pid);

    int deleteByPidUid(@Param("pid") int pid, @Param("uid") int uid);

    int deleteByPid(int pid);
}
