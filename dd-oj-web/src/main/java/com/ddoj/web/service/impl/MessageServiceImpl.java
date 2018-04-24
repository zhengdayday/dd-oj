package com.ddoj.web.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ddoj.web.dao.MessageMapper;
import com.ddoj.web.entity.MessageEntity;
import com.ddoj.web.service.MessageService;
import com.github.pagehelper.PageRowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhengtt
 **/
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public int save(int owner, int type, String content, JSONObject json) {
        MessageEntity entity = new MessageEntity();
        entity.setOwner(owner);
        entity.setType(type);
        entity.setContent(content);

        if (json == null) {
            entity.setJsonContent(new JSONObject());
        } else {
            entity.setJsonContent(json);
        }

        entity.setCreateTime(System.currentTimeMillis());
        boolean flag = messageMapper.save(entity) == 1;
        return flag? entity.getMid(): 0;
    }

    @Override
    public List<MessageEntity> listUserMessages(int owner) {
        return messageMapper.listMessagesByOwner(owner);
    }
}
