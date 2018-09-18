package com.luckyhit.service;

import com.luckyhit.domain.UserInfo;
import com.luckyhit.entity.UserInfoEntity;
import com.luckyhit.mapper.UserInfoMapper;
import com.luckyhit.utils.FastJsonUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    UserInfoMapper mapper;

    public UserInfo getUserInfoById(String id){
        return translateEntity2Model(mapper.selectByPrimaryKey(id));
    }

    public List<UserInfo> getUserInfoList() {
        List<UserInfo> userInfos = new ArrayList<>();
        List<UserInfoEntity> userInfoEntities = mapper.selectList();
        for (UserInfoEntity userInfoEntity : userInfoEntities) {
            userInfos.add(translateEntity2Model(userInfoEntity));
        }
        return userInfos;
    }

    public boolean addUserInfo(UserInfo userInfo) {
        UserInfoEntity userInfoEntity = translateModel2Entity(userInfo);
        return mapper.insert(userInfoEntity) > 0;
    }

    public boolean deleteUserInfoById(String id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    public boolean updateUserInfo(UserInfo userInfo) {
        UserInfoEntity userInfoEntity = translateModel2Entity(userInfo);
        return mapper.updateByPrimaryKey(userInfoEntity) > 0;
    }

    private UserInfoEntity translateModel2Entity(UserInfo userInfo) {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        BeanUtils.copyProperties(userInfo, userInfoEntity);
        userInfoEntity.setFlavorList(FastJsonUtils.pubOrPubsToJson(userInfo.getFlavorList()));
        return userInfoEntity;
    }

    private UserInfo translateEntity2Model(UserInfoEntity userInfoEntity) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoEntity, userInfo);
        userInfo.setFlavorList(FastJsonUtils.jsonToPubs(userInfoEntity.getFlavorList(), Integer.class));
        return userInfo;
    }
}
