package com.ddoj.web.service.impl;

import com.ddoj.web.controller.exception.WebErrorException;
import com.ddoj.web.dao.AttachmentMapper;
import com.ddoj.web.entity.AttachmentEntity;
import com.ddoj.web.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhengtt
 **/
@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    private AttachmentMapper mapper;

    @Override
    public int save(int owner, String url) {
        AttachmentEntity attachmentEntity = new AttachmentEntity();
        attachmentEntity.setOwner(owner);
        attachmentEntity.setUrl(url);
        attachmentEntity.setUploadTime(System.currentTimeMillis());
        boolean flag = mapper.save(attachmentEntity) == 1;
        return flag? attachmentEntity.getAid(): 0;
    }

    @Override
    public AttachmentEntity getAvatar(int aid) throws WebErrorException {
        AttachmentEntity entity = mapper.getByAid(aid);
        if (entity == null) {
            throw new WebErrorException("不存在此头像");
        }
        return mapper.getByAid(aid);
    }
}
