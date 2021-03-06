package com.luckyhit.domain;

import java.util.Date;
import java.util.List;

public class RestaurantInfo {
    private Integer id;
    private String name;
    private String address;
    private List<Integer> flavorList;
    private String image;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Integer> getFlavorList() {
        return flavorList;
    }

    public void setFlavorList(List<Integer> flavorList) {
        this.flavorList = flavorList;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public String toString() {
        return "RestaurantInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", flavorList=" + flavorList +
                ", image='" + image + '\'' +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }
}
