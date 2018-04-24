package com.ddoj.web.service;

import com.ddoj.web.entity.AttachmentEntity;

/**
 * @author zhengtt
 **/
public interface AttachmentService {

    int save(int owner, String url);

    AttachmentEntity getAvatar(int aid);
}
