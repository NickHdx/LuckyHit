package com.luckyhit.mapper;

import com.luckyhit.entity.FlavorMapEntity;

import java.util.List;

public interface FlavorMapMapper {
    FlavorMapEntity selectByPrimaryKey(Integer id);
    List<FlavorMapEntity> selectList();
    List<FlavorMapEntity> selectListByUserId(String userId);
    int deleteByPrimaryKey(Integer id);
    int insert(FlavorMapEntity restaurantInfoEntity);
    int updateByPrimaryKey(FlavorMapEntity restaurantInfoEntity);
}
