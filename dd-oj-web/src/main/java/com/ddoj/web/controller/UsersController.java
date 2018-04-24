package com.ddoj.web.controller;

import com.ddoj.web.entity.ResponseEntity;
import com.ddoj.web.service.UserService;
import com.ddoj.web.util.WebUtil;
import com.ddoj.web.entity.ResponseEntity;
import com.ddoj.web.service.UserService;
import com.ddoj.web.util.WebUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengtt
 **/
@RestController
@Validated
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping
    @RequiresRoles(value = {"8", "9"}, logical = Logical.OR)
    public ResponseEntity listUsers(@RequestParam("page") int page,
                                    @RequestParam("page_size") int pageSize) {
        Page pager = PageHelper.startPage(page, pageSize);
        return new ResponseEntity(WebUtil.generatePageData(pager, userService.listAll()));
    }
}
