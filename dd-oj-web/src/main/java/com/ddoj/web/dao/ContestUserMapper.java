package com.ddoj.web.dao;

import com.ddoj.web.entity.ContestUserEntity;
import com.ddoj.web.entity.ContestUserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author zhengtt
 **/
@Repository
public interface ContestUserMapper {
    int save(ContestUserEntity entity);

    int countByCid(int cid);

    ContestUserEntity getByCidUid(@Param("cid") int cid, @Param("uid") int uid);

    List<Map<String, Object>> listUserJoinedContestsByUid(int uid);

    int updateByCidUid(@Param("cid") int cid, @Param("uid") int uid, @Param("data") ContestUserEntity data);
}
