package com.luckyhit.controller;

import com.luckyhit.domain.FlavorMap;
import com.luckyhit.domain.RestaurantInfo;
import com.luckyhit.domain.UserInfo;
import com.luckyhit.service.FlavorInfoService;
import com.luckyhit.service.FlavorMapService;
import com.luckyhit.service.RestaurantInfoService;
import com.luckyhit.service.UserInfoService;
import com.luckyhit.utils.FastJsonUtils;
import com.luckyhit.utils.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RequestMapping("/luckyhit/api/match")
@RestController
public class MatchController {
    @Autowired
    UserInfoService userInfoService;

    @Autowired
    RestaurantMapper restaurantMapper;

    @Autowired
    FlavorMapService flavorMapService;

    @Autowired
    RestaurantInfoService restaurantInfoService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Map<String, List<RestaurantInfo>> match(@RequestBody Map<String, Object> parameters) {
        if (!parameters.containsKey("userInfo") || parameters.get("userInfo") == null) {
            return null;
        }
//        LinkedHashMap map = (LinkedHashMap)parameters.get("userInfo");
//        String id = map.get("id").toString();
//        List<Integer> flavorList = new ArrayList<>();
//        for (Object m : (ArrayList)map.get("flavorList")) {
//            LinkedHashMap hashMap = (LinkedHashMap) m;
//            flavorList.add(new Integer(hashMap.get("flavorId").toString()));
//        }
//
//        UserInfo userInfo = userInfoService.getUserInfoById(id);
//        userInfo.setFlavorList(flavorList);
//        userInfoService.updateUserInfo(userInfo);
//
//        FlavorMap flavorMap = new FlavorMap();
//        flavorMap.setUserId(userInfo.getId());
//        flavorMap.setFlavorList(userInfo.getFlavorList());
//        flavorMap.setLastUpdateTime(new Date());
//        flavorMapService.addFlavorMap(flavorMap);

        List<RestaurantInfo> restaurantInfos = restaurantInfoService.getRestaurantInfoList();
        Map<String, List<RestaurantInfo>> result = new HashMap<>();
        result.put("restaurantInfoList", restaurantInfos.subList(0,3));
        return result;
    }

    @RequestMapping(value = "/2", method = RequestMethod.POST, produces = "application/json")
    public Map<String, List<RestaurantInfo>> match2(@RequestBody Map<String, Object> parameters) {
        if (!parameters.containsKey("userId")) {
            return null;
        }
//        String userId = parameters.get("userId").toString();
//        UserInfo userInfo = userInfoService.getUserInfoById(userId);

        Map<String, List<RestaurantInfo>> result = new HashMap<>();
        List<RestaurantInfo> restaurantInfos = restaurantInfoService.getRestaurantInfoList();
        List<RestaurantInfo> restaurants = new ArrayList<>();

        while (result.size() < 3) {
                int random = (int) (Math.random() * restaurantInfos.size());
                restaurants.add(restaurantInfos.get(random));
        }

        result.put("restaurantInfoList", restaurants);
        return result;
    }
}
