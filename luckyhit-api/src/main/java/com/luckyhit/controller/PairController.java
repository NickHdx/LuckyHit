package com.luckyhit.controller;

import com.luckyhit.domain.*;
import com.luckyhit.service.FlavorMapService;
import com.luckyhit.service.OrderInfoService;
import com.luckyhit.service.UserInfoService;
import com.luckyhit.utils.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/luckyhit/api/pair")
@RestController
public class PairController {
    @Autowired
    UserInfoService userInfoService;

    @Autowired
    RestaurantMapper restaurantMapper;

    @Autowired
    FlavorMapService flavorMapService;

    @Autowired
    OrderInfoService orderInfoService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public OrderInfo pair(@RequestBody  Map<String, Object> parameters) throws ParseException, InterruptedException {
        if (!parameters.containsKey("restaurantId") || !parameters.containsKey("userId")) {
            return null;
        }

        String userId = parameters.get("userId").toString();
        int restaurantId = Integer.parseInt(parameters.get("restaurantId").toString());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        UserInfo userInfo = userInfoService.getUserInfoById(userId);
        userInfo.setStatus(UserStatus.Pending);
        userInfoService.updateUserInfo(userInfo);

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setStatus(OrderStatus.Pending);
        orderInfo.setRestaurantId(restaurantId);
        orderInfo.setDiningBeginTime(dateFormat.parse(parameters.get("startTime").toString()));
        orderInfo.setDiningEndTime(dateFormat.parse(parameters.get("endTime").toString()));
        orderInfo.setFirstUserId(userId);
        orderInfo.setLastUpdateTime(new Date());
        int orderId = orderInfoService.addOrderInfo(orderInfo);
        for(int i = 0; i<5; i++){
            List<OrderInfo> allOrderInfoList = orderInfoService.getOrderInfoList();
            for (OrderInfo order : allOrderInfoList){
                if(order.getId()==orderId)continue;
                if(order.getStatus().equals(OrderStatus.Pending) &&
                        order.getRestaurantId() == orderInfo.getRestaurantId() &&
                        orderInfo.getDiningBeginTime().getTime()==order.getDiningBeginTime().getTime()&&
                        order.getSecondUserId() == null){
                    orderInfo.setSecondUserId(order.getFirstUserId());
                    order.setSecondUserId(orderInfo.getFirstUserId());
                    orderInfoService.updateOrderInfo(orderInfo);
                    orderInfoService.updateOrderInfo(order);
                    i=6;
                    break;
                }
            }
            Thread.sleep(5000);
        }

        return  orderInfo.getSecondUserId()!= null ? orderInfo:null;
    }

    @RequestMapping(value = "/confirm",method = RequestMethod.POST, produces = "application/json")
    public void confirmOrder(@RequestBody Map<String, Object> parameters){
        int orderId = Integer.parseInt(parameters.get("orderId").toString());
        OrderInfo order = orderInfoService.getOrderInfoById(orderId);
        order.setStatus(OrderStatus.Done);
    }

    @RequestMapping(value = "/cancel",method = RequestMethod.POST, produces = "application/json")
    public void cancelOrder(@RequestBody Map<String, Object> parameters){
        int orderId = Integer.parseInt(parameters.get("orderId").toString());
        orderInfoService.deleteOrderInfoById(orderId);
    }
}
