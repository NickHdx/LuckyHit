package com.luckyhit.service;

import com.luckyhit.domain.OrderInfo;
import com.luckyhit.mapper.OrderInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInfoService {
    @Autowired
    OrderInfoMapper mapper;

    public OrderInfo getOrderInfoById(int id){
        return mapper.selectByPrimaryKey(id);
    }

    public List<OrderInfo> getOrderInfoList() {
        return mapper.selectList();
    }

    public int addOrderInfo(OrderInfo orderInfo) {
        mapper.insert(orderInfo);
        return orderInfo.getId();
    }

    public boolean deleteOrderInfoById(int id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    public boolean updateOrderInfo(OrderInfo orderInfo) {
        return mapper.updateByPrimaryKey(orderInfo) > 0;
    }
}
