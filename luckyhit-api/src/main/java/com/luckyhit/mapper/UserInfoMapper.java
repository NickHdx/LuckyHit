package com.luckyhit.mapper;

import com.luckyhit.entity.UserInfoEntity;

import java.util.List;

public interface UserInfoMapper {
    UserInfoEntity selectByPrimaryKey(String id);
    List<UserInfoEntity> selectList();
    int deleteByPrimaryKey(String id);
    int insert(UserInfoEntity userInfoEntity);
    int updateByPrimaryKey(UserInfoEntity userInfoEntity);
}
