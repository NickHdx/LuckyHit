package com.luckyhit.service;

import com.luckyhit.domain.OrderInfo;
import com.luckyhit.domain.OrderStatus;
import com.luckyhit.entity.OrderInfoEntity;
import com.luckyhit.mapper.OrderInfoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderInfoService {
    @Autowired
    OrderInfoMapper mapper;

    public OrderInfo getOrderInfoById(int id){
        return translateEntity2Model(mapper.selectByPrimaryKey(id));
    }

    public List<OrderInfo> getOrderInfoListByFirstUserId(String firstUserId) {
        List<OrderInfo> orderInfoList = new ArrayList<>();
        for (OrderInfoEntity orderInfoEntity : mapper.selectByFirstUserId(firstUserId)) {
            orderInfoList.add(translateEntity2Model(orderInfoEntity));
        }
        return  orderInfoList;
    }

    public List<OrderInfo> getOrderInfoList() {
        List<OrderInfo> orderInfoList = new ArrayList<>();
        for (OrderInfoEntity orderInfoEntity : mapper.selectList()) {
            orderInfoList.add(translateEntity2Model(orderInfoEntity));
        }
        return  orderInfoList;
    }

    public int addOrderInfo(OrderInfo orderInfo) {
        OrderInfoEntity orderInfoEntity = translateModel2Entity(orderInfo);
        mapper.insert(orderInfoEntity);
        return orderInfoEntity.getId();
    }

    public boolean deleteOrderInfoById(int id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    public boolean updateOrderInfo(OrderInfo orderInfo) {
        return mapper.updateByPrimaryKey(translateModel2Entity(orderInfo)) > 0;
    }

    private OrderInfoEntity translateModel2Entity(OrderInfo orderInfo) {
        OrderInfoEntity orderInfoEntity = new OrderInfoEntity();
        BeanUtils.copyProperties(orderInfo, orderInfoEntity);
        orderInfoEntity.setStatus(orderInfo.getStatus().getValue());
        return orderInfoEntity;
    }

    private OrderInfo translateEntity2Model(OrderInfoEntity orderInfoEntity) {
        OrderInfo orderInfo = new OrderInfo();
        BeanUtils.copyProperties(orderInfoEntity, orderInfo);
        orderInfo.setStatus(OrderStatus.getEnum(orderInfoEntity.getStatus()));
        return orderInfo;
    }
}
