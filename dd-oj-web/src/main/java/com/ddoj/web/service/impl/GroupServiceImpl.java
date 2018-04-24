package com.ddoj.web.service.impl;

import com.ddoj.web.controller.exception.WebErrorException;
import com.ddoj.web.dao.ContestMapper;
import com.ddoj.web.dao.GroupMapper;
import com.ddoj.web.entity.ContestEntity;
import com.ddoj.web.entity.GroupEntity;
import com.ddoj.web.service.ContestService;
import com.ddoj.web.service.GroupService;
import com.ddoj.web.service.GroupUserService;
import com.ddoj.web.util.WebUtil;
import com.github.pagehelper.PageRowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhengtt
 **/
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private ContestService contestService;

    @Autowired
    private GroupUserService groupUserService;

    @Override
    public int saveGroup(int owner, String name, String password) {
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setOwner(owner);
        groupEntity.setPassword(password);
        groupEntity.setName(name);
        groupEntity.setCreateTime(System.currentTimeMillis());
        boolean flag= groupMapper.save(groupEntity) == 1;
        WebUtil.assertIsSuccess(flag, "小组创建失败");
        return groupEntity.getGid();
    }

    @Override
    public int countGroups() {
        return groupMapper.count();
    }

    @Transactional
    @Override
    public void deleteGroup(int gid) {
        int contests = contestService.countGroupContests(gid);
        if (contests != 0) {
            throw new WebErrorException("小组内已有比赛开设，无法解散小组");
        }

        if (groupUserService.countGroupMembers(gid) > 0) {
            groupUserService.deleteGroupMembers(gid);
        }
        boolean flag = groupMapper.deleteByGid(gid) == 1;
        WebUtil.assertIsSuccess(flag, "小组解散失败");
    }

    @Override
    public GroupEntity getGroup(int gid) {
        GroupEntity groupEntity = groupMapper.getGroupByGid(gid);
        WebUtil.assertNotNull(groupEntity, "小组不存在");
        return groupEntity;
    }

    @Override
    public List<GroupEntity> listUserGroups(int owner) {
        return groupMapper.listGroupsByOwner(owner);
    }

    @Override
    public List<GroupEntity> listAll() {
        return groupMapper.listAll();
    }

    @Override
    public boolean updateGroupByGid(int gid, String name, String password) {
        GroupEntity entity = new GroupEntity();
        entity.setName(name);
        entity.setPassword(password);
        return groupMapper.updateByGid(gid, entity) == 1;
    }
}
