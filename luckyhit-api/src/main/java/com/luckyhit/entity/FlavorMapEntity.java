package com.luckyhit.entity;

import java.util.Date;

public class FlavorMapEntity {
    private Integer id;
    private String userId;
    private String flavorList;
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

    public String getFlavorList() {
        return flavorList;
    }

    public void setFlavorList(String flavorList) {
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
        return "FlavorMapEntity{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", flavorList='" + flavorList + '\'' +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }
}
