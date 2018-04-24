package com.ddoj.web.service;

import com.ddoj.web.entity.TagEntity;

import java.util.List;

/**
 * @author zhengtt
 **/
public interface TagsService {

    TagEntity getByName(String name);

    int save(String name);

    void deleteTag(int tid);

    List<TagEntity> listAll();

    void addUsedTimes(int tid);

    void updateTagName(int tid, String name);
}
