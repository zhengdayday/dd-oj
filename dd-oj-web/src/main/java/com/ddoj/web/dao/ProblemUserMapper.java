package com.ddoj.web.dao;

import com.ddoj.web.entity.ProblemUserEntity;
import com.ddoj.web.entity.ProblemUserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author zhengtt
 **/
@Repository
public interface ProblemUserMapper {
    int save(ProblemUserEntity problemUserEntity);

    ProblemUserEntity getByPidUid(@Param("pid") int pid, @Param("uid") int uid);

    List<Map<String, Object>> listUserProblemsByUid(int uid);

    int updateByPidUid(@Param("pid") int pid, @Param("uid") int uid, @Param("data") ProblemUserEntity data);
}
