package com.luckyhit.entity;

import java.util.Date;

public class RestaurantInfoEntity {
    private Integer id;
    private String name;
    private String address;
    private String flavorList;
    private String smallImage;
    private String bigImage;
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

    public String getFlavorList() {
        return flavorList;
    }

    public void setFlavorList(String flavorList) {
        this.flavorList = flavorList;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public String getBigImage() {
        return bigImage;
    }

    public void setBigImage(String bigImage) {
        this.bigImage = bigImage;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public String toString() {
        return "RestaurantInfoEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", flavorList='" + flavorList + '\'' +
                ", smallImage='" + smallImage + '\'' +
                ", bigImage='" + bigImage + '\'' +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }
}
