package com.luckyhit.controller;

import com.luckyhit.domain.OrderInfo;
import com.luckyhit.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("/luckyhit/api/orderinfo")
@RestController
public class OrderInfoController {
    @Autowired
    OrderInfoService service;

    @RequestMapping(value = "/get", method = RequestMethod.POST, produces = "application/json")
    public OrderInfo get(int id) {
        return service.getOrderInfoById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public int add(@RequestBody OrderInfo orderInfo) {
        orderInfo.setLastUpdateTime(new Date());
        return service.addOrderInfo(orderInfo);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public boolean update(@RequestBody OrderInfo orderInfo) {
        orderInfo.setLastUpdateTime(new Date());
        return service.updateOrderInfo(orderInfo);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public boolean delete(@RequestBody OrderInfo orderInfo) {
        return service.deleteOrderInfoById(orderInfo.getId());
    }
}
