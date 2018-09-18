package com.luckyhit.service;

import com.luckyhit.domain.FlavorInfo;
import com.luckyhit.mapper.FlavorInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlavorInfoService {
    @Autowired
    FlavorInfoMapper mapper;

    public FlavorInfo getFlavorInfoById(int id){
        return mapper.selectByPrimaryKey(id);
    }

    public List<FlavorInfo> getFlavorInfoList() {
        return mapper.selectList();
    }

    public int addFlavorInfo(FlavorInfo flavorInfo) {
        mapper.insert(flavorInfo);
        return flavorInfo.getId();
    }

    public boolean deleteFlavorInfoById(int id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    public boolean updateFlavorInfo(FlavorInfo flavorInfo) {
        return mapper.updateByPrimaryKey(flavorInfo) > 0;
    }
}
