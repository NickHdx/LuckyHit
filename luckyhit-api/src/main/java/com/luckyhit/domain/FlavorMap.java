package com.luckyhit.domain;

import java.util.Date;
import java.util.List;

public class FlavorMap {
    private Integer id;
    private String userId;
    private List<Integer> flavorList;
    private Date lastUpdateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Integer> getFlavorList() {
        return flavorList;
    }

    public void setFlavorList(List<Integer> flavorList) {
        this.flavorList = flavorList;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public String toString() {
        return "FlavorMap{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", flavorList=" + flavorList +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }
}
