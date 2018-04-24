package com.ddoj.web.dao;

import com.ddoj.web.entity.AttachmentEntity;
import com.ddoj.web.entity.AttachmentEntity;
import org.springframework.stereotype.Repository;

/**
 * @author zhengtt
 **/
@Repository
public interface AttachmentMapper {
    int save(AttachmentEntity entity);

    AttachmentEntity getByAid(int aid);
}
