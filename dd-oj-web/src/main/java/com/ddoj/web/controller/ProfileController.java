package com.ddoj.web.controller;

import com.ddoj.web.entity.ResponseEntity;
import com.ddoj.web.entity.UserEntity;
import com.ddoj.web.service.UserService;
import com.ddoj.web.entity.ResponseEntity;
import com.ddoj.web.entity.UserEntity;
import com.ddoj.web.service.SubmissionService;
import com.ddoj.web.service.UserLogService;
import com.ddoj.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengtt
 **/
@RestController
@Validated
@RequestMapping(value = "/profile", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/{uid}")
    public ResponseEntity getProfile(@PathVariable int uid) {
        UserEntity userEntity = userService.getUserByUid(uid);
        userEntity.setPassword(null);
        userEntity.setEmail(null);
        userEntity.setRole(null);
        userEntity.setPermission(null);
        return new ResponseEntity(userEntity);
    }
}
