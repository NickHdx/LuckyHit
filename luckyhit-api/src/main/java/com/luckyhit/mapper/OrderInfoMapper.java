package com.luckyhit.mapper;

import com.luckyhit.domain.OrderInfo;
import com.luckyhit.entity.OrderInfoEntity;

import java.util.List;

public interface OrderInfoMapper {
    OrderInfoEntity selectByPrimaryKey(Integer id);
    List<OrderInfoEntity> selectList();
    List<OrderInfoEntity> selectByFirstUserId(String firstUserId);
    int deleteByPrimaryKey(Integer id);
    int insert(OrderInfoEntity orderInfoEntity);
    int updateByPrimaryKey(OrderInfoEntity orderInfoEntity);
}
