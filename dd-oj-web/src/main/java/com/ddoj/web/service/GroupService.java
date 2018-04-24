package com.ddoj.web.service;

import com.ddoj.web.entity.ContestEntity;
import com.ddoj.web.entity.GroupEntity;
import java.util.List;

/**
 * @author zhengtt
 **/
public interface GroupService {

    int saveGroup(int owner, String name, String password);

    int countGroups();

    void deleteGroup(int gid);

    GroupEntity getGroup(int gid);

    List<GroupEntity> listUserGroups(int owner);

    List<GroupEntity> listAll();

    boolean updateGroupByGid(int gid, String name, String password);
}
