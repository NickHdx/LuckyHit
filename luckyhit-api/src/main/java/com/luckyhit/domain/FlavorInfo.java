package com.luckyhit.domain;

import java.util.Date;

public class FlavorInfo {
    private Integer id;
    private String name;
    private Date lastUpdateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public String toString() {
        return "FlavorInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }
}
