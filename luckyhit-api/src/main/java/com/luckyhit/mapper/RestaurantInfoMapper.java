package com.luckyhit.mapper;

import com.luckyhit.entity.RestaurantInfoEntity;

import java.util.List;

public interface RestaurantInfoMapper {
    RestaurantInfoEntity selectByPrimaryKey(Integer id);
    List<RestaurantInfoEntity> selectList();
    int deleteByPrimaryKey(Integer id);
    int insert(RestaurantInfoEntity restaurantInfoEntity);
    int updateByPrimaryKey(RestaurantInfoEntity restaurantInfoEntity);
}
