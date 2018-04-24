package com.ddoj.web.controller;

import com.ddoj.web.entity.ResponseEntity;
import com.ddoj.web.service.ContestService;
import com.ddoj.web.service.GroupService;
import com.ddoj.web.service.ProblemService;
import com.ddoj.web.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengtt
 **/
@RestController
@Validated
@RequestMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdminController {

    @Autowired
    private ContestService contestService;

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private ProblemService problemService;

    @ApiOperation("获取系统的大致信息")
    @RequiresRoles(value = {"8", "9"}, logical = Logical.OR)
    @GetMapping("/overview")
    public ResponseEntity getOverview() {
        Map<String, Integer> data = new HashMap<>(5);
        data.put("contests", contestService.countContests());
        data.put("users", userService.countUsers());
        data.put("groups", groupService.countGroups());
        data.put("problems", problemService.countProblems());
        data.put("auditing_problems", problemService.countAuditingProblems());
        return new ResponseEntity(data);
    }
}
