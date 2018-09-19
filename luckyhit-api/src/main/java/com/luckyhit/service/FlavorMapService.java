package com.luckyhit.service;

import com.luckyhit.domain.FlavorMap;
import com.luckyhit.entity.FlavorMapEntity;
import com.luckyhit.mapper.FlavorMapMapper;
import com.luckyhit.utils.FastJsonUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlavorMapService {
    @Autowired
    FlavorMapMapper mapper;

    public FlavorMap getFlavorMapById(int id){
        return translateEntity2Model(mapper.selectByPrimaryKey(id));
    }

    public List<FlavorMap> getFlavorMapListByUserId(String userId) {
        List<FlavorMap> flavorMaps = new ArrayList<>();
        List<FlavorMapEntity> flavorMapEntities = mapper.selectListByUserId(userId);
        for (FlavorMapEntity flavorMapEntity : flavorMapEntities) {
            flavorMaps.add(translateEntity2Model(flavorMapEntity));
        }
        return flavorMaps;
    }

    public List<FlavorMap> getFlavorMapList() {
        List<FlavorMap> flavorMaps = new ArrayList<>();
        List<FlavorMapEntity> flavorMapEntities = mapper.selectList();
        for (FlavorMapEntity flavorMapEntity : flavorMapEntities) {
            flavorMaps.add(translateEntity2Model(flavorMapEntity));
        }
        return flavorMaps;
    }

    public int addFlavorMap(FlavorMap flavorMap) {
        FlavorMapEntity flavorMapEntity = translateModel2Entity(flavorMap);
        mapper.insert(flavorMapEntity);
        return flavorMapEntity.getId();
    }

    public boolean deleteFlavorMapById(int id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    public boolean updateFlavorMap(FlavorMap flavorMap) {
        FlavorMapEntity flavorMapEntity = translateModel2Entity(flavorMap);
        return mapper.updateByPrimaryKey(flavorMapEntity) > 0;
    }

    private FlavorMapEntity translateModel2Entity(FlavorMap flavorMap) {
        FlavorMapEntity flavorMapEntity = new FlavorMapEntity();
        BeanUtils.copyProperties(flavorMap, flavorMapEntity);
        flavorMapEntity.setFlavorList(FastJsonUtils.pubOrPubsToJson(flavorMap.getFlavorList()));
        return flavorMapEntity;
    }

    private FlavorMap translateEntity2Model(FlavorMapEntity flavorMapEntity) {
        FlavorMap flavorMap = new FlavorMap();
        BeanUtils.copyProperties(flavorMapEntity, flavorMap);
        flavorMap.setFlavorList(FastJsonUtils.jsonToPubs(flavorMapEntity.getFlavorList(), Integer.class));
        return flavorMap;
    }
}
