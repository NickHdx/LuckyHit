package com.luckyhit.controller;

import com.luckyhit.domain.RestaurantInfo;
import com.luckyhit.service.RestaurantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("/luckyhit/api/restaurantinfo")
@RestController
public class RestaurantInfoController {
    @Autowired
    RestaurantInfoService service;

    @RequestMapping(value = "/get", method = RequestMethod.POST, produces = "application/json")
    public RestaurantInfo get(int id) {
        return service.getRestaurantInfoById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public int add(@RequestBody RestaurantInfo restaurantInfo) {
        restaurantInfo.setLastUpdateTime(new Date());
        return service.addRestaurantInfo(restaurantInfo);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public boolean update(@RequestBody RestaurantInfo restaurantInfo) {
        restaurantInfo.setLastUpdateTime(new Date());
        return service.updateRestaurantInfo(restaurantInfo);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public boolean delete(@RequestBody RestaurantInfo restaurantInfo) {
        return service.deleteRestaurantInfoById(restaurantInfo.getId());
    }
}
