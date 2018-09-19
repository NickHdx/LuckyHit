package com.luckyhit.domain;

import java.util.Date;
import java.util.List;

public class UserInfo {
    private String id;
    private String name;
    private List<Integer> flavorList;
    private UserStatus status;
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

    public List<Integer> getFlavorList() {
        return flavorList;
    }

    public void setFlavorList(List<Integer> flavorList) {
        this.flavorList = flavorList;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", flavorList=" + flavorList +
                ", status=" + status +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}
