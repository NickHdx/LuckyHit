package com.luckyhit.entity;

import java.util.Date;

public class UserInfoEntity {
    private String id;
    private String name;
    private String flavorList;
    private Date lastLoginTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavorList() {
        return flavorList;
    }

    public void setFlavorList(String flavorList) {
        this.flavorList = flavorList;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "UserInfoEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", flavorList='" + flavorList + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}
