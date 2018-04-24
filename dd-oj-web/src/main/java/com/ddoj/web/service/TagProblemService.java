package com.ddoj.web.service;

import com.ddoj.web.entity.TagProblemEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhengtt
 **/
@Service
public interface TagProblemService {

    void saveProblemTag(int tid, int pid);

    void deleteProblemTags(int pid);

    int countTagProblems(int tid);

    List<TagProblemEntity> getProblemTags(int pid);
}
