package com.ddoj.web.dao;

import com.ddoj.web.entity.MessageEntity;
import com.ddoj.web.entity.MessageEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhengtt
 **/
@Repository
public interface MessageMapper {
    int save(MessageEntity messageEntity);

    List<MessageEntity> listMessagesByOwner(int owner);
}
