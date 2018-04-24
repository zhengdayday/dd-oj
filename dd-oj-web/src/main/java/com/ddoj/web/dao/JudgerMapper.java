package com.ddoj.web.dao;

import com.ddoj.web.entity.JudgerEntity;
import com.ddoj.web.entity.JudgerEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhengtt
 **/
@Repository
public interface JudgerMapper {

    List<JudgerEntity> listAll();

    int save(JudgerEntity judgerEntity);

    int deleteByJid(int jid);

    int updateByJid(@Param("jid") int jid, @Param("data") JudgerEntity data);
}
