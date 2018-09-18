package com.luckyhit.controller;

import com.luckyhit.domain.UserInfo;
import com.luckyhit.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("/luckyhit/api/userinfo")
@RestController
public class UserInfoController {
    @Autowired
    UserInfoService service;

    @RequestMapping(value = "/get", method = RequestMethod.POST, produces = "application/json")
    public UserInfo get(String id) {
        return service.getUserInfoById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public boolean add(@RequestBody UserInfo userInfo) {
        userInfo.setLastLoginTime(new Date());
        return service.addUserInfo(userInfo);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public boolean update(@RequestBody UserInfo userInfo) {
        userInfo.setLastLoginTime(new Date());
        return service.updateUserInfo(userInfo);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public boolean delete(@RequestBody UserInfo userInfo) {
        return service.deleteUserInfoById(userInfo.getId());
    }
}
