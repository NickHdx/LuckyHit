package com.luckyhit.controller;

import com.luckyhit.domain.FlavorMap;
import com.luckyhit.domain.UserInfo;
import com.luckyhit.domain.UserStatus;
import com.luckyhit.service.FlavorMapService;
import com.luckyhit.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/luckyhit/api/userinfo")
@RestController
public class UserInfoController {
    @Autowired
    UserInfoService service;

    @Autowired
    FlavorMapService flavorMapService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public Map<String, UserInfo> login(@RequestBody Map<String, Object> parameters) {
        if (!parameters.containsKey("nickName")) {
            return null;
        }
        String nickName = parameters.get("nickName").toString();
        if (nickName == null || nickName.isEmpty()) {
            return null;
        }
        String id = new Integer(nickName.hashCode()).toString();
        UserInfo userInfo = service.getUserInfoById(id);
        if (userInfo == null) {
            userInfo = new UserInfo();
            userInfo.setId(id);
            userInfo.setName(nickName);
            userInfo.setStatus(UserStatus.Online);
            userInfo.setLastLoginTime(new Date());
            service.addUserInfo(userInfo);
        }
        Map<String, UserInfo> result = new HashMap<>();
        result.put("userInfo", userInfo);
        return result;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST, produces = "application/json")
    public UserInfo get(String id) {
        return service.getUserInfoById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public boolean add(@RequestBody UserInfo userInfo) {
        userInfo.setStatus(UserStatus.Online);
        userInfo.setLastLoginTime(new Date());
        FlavorMap flavorMap = new FlavorMap();
        flavorMap.setUserId(userInfo.getId());
        flavorMap.setFlavorList(userInfo.getFlavorList());
        flavorMap.setLastUpdateTime(new Date());
        flavorMapService.addFlavorMap(flavorMap);
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
