package com.luckyhit.mapper;

import com.luckyhit.domain.OrderInfo;

import java.util.List;

public interface OrderInfoMapper {
    OrderInfo selectByPrimaryKey(Integer id);
    List<OrderInfo> selectList();
    int deleteByPrimaryKey(Integer id);
    int insert(OrderInfo orderInfo);
    int updateByPrimaryKey(OrderInfo orderInfo);
}
