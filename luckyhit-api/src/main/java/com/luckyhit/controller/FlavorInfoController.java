package com.luckyhit.controller;

import com.luckyhit.domain.FlavorInfo;
import com.luckyhit.service.FlavorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("/luckyhit/api/flavorinfo")
@RestController
public class FlavorInfoController {
    @Autowired
    FlavorInfoService service;

    @RequestMapping(value = "/get", method = RequestMethod.POST, produces = "application/json")
    public FlavorInfo get(int id) {
        return service.getFlavorInfoById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public int add(@RequestBody FlavorInfo flavorInfo) {
        flavorInfo.setLastUpdateTime(new Date());
        return service.addFlavorInfo(flavorInfo);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public boolean update(@RequestBody FlavorInfo flavorInfo) {
        flavorInfo.setLastUpdateTime(new Date());
        return service.updateFlavorInfo(flavorInfo);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public boolean delete(@RequestBody FlavorInfo flavorInfo) {
        return service.deleteFlavorInfoById(flavorInfo.getId());
    }
}
