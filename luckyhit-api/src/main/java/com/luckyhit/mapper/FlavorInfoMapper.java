package com.luckyhit.mapper;

import com.luckyhit.domain.FlavorInfo;

import java.util.List;

public interface FlavorInfoMapper {
    FlavorInfo selectByPrimaryKey(Integer id);
    List<FlavorInfo> selectList();
    int deleteByPrimaryKey(Integer id);
    int insert(FlavorInfo flavorInfo);
    int updateByPrimaryKey(FlavorInfo flavorInfo);
}
