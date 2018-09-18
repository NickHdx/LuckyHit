package com.luckyhit.service;

import com.luckyhit.domain.RestaurantInfo;
import com.luckyhit.entity.RestaurantInfoEntity;
import com.luckyhit.mapper.RestaurantInfoMapper;
import com.luckyhit.utils.FastJsonUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantInfoService {
    @Autowired
    RestaurantInfoMapper mapper;

    public RestaurantInfo getRestaurantInfoById(int id){
        return translateEntity2Model(mapper.selectByPrimaryKey(id));
    }

    public List<RestaurantInfo> getRestaurantInfoList() {
        List<RestaurantInfo> restaurantInfos = new ArrayList<>();
        List<RestaurantInfoEntity> restaurantInfoEntities = mapper.selectList();
        for (RestaurantInfoEntity restaurantInfoEntity : restaurantInfoEntities) {
            restaurantInfos.add(translateEntity2Model(restaurantInfoEntity));
        }
        return restaurantInfos;
    }

    public int addRestaurantInfo(RestaurantInfo restaurantInfo) {
        RestaurantInfoEntity restaurantInfoEntity = translateModel2Entity(restaurantInfo);
        mapper.insert(restaurantInfoEntity);
        return restaurantInfoEntity.getId();
    }

    public boolean deleteRestaurantInfoById(int id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    public boolean updateRestaurantInfo(RestaurantInfo restaurantInfo) {
        RestaurantInfoEntity restaurantInfoEntity = translateModel2Entity(restaurantInfo);
        return mapper.updateByPrimaryKey(restaurantInfoEntity) > 0;
    }

    private RestaurantInfoEntity translateModel2Entity(RestaurantInfo restaurantInfo) {
        RestaurantInfoEntity restaurantInfoEntity = new RestaurantInfoEntity();
        BeanUtils.copyProperties(restaurantInfo, restaurantInfoEntity);
        restaurantInfoEntity.setFlavorList(FastJsonUtils.pubOrPubsToJson(restaurantInfo.getFlavorList()));
        return restaurantInfoEntity;
    }

    private RestaurantInfo translateEntity2Model(RestaurantInfoEntity restaurantInfoEntity) {
        RestaurantInfo restaurantInfo = new RestaurantInfo();
        BeanUtils.copyProperties(restaurantInfoEntity, restaurantInfo);
        restaurantInfo.setFlavorList(FastJsonUtils.jsonToPubs(restaurantInfoEntity.getFlavorList(), Integer.class));
        return restaurantInfo;
    }
}
