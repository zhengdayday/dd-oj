package com.ddoj.web.service;

import com.alibaba.fastjson.JSONObject;
import com.ddoj.web.entity.MessageEntity;

import java.util.List;

/**
 * @author zhengtt
 **/
public interface MessageService {

    int save(int owner, int type, String content, JSONObject json);

    List<MessageEntity> listUserMessages(int owner);
}
