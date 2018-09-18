package com.luckyhit.domain;

import java.util.Date;

public class OrderInfo {
    private Integer id;
    private String firstUserId;
    private String secondUserId;
    private Integer restaurantId;
    private Date diningBeginTime;
    private Date diningEndTime;
    private Date lastUpdateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstUserId() {
        return firstUserId;
    }

    public void setFirstUserId(String firstUserId) {
        this.firstUserId = firstUserId;
    }

    public String getSecondUserId() {
        return secondUserId;
    }

    public void setSecondUserId(String secondUserId) {
        this.secondUserId = secondUserId;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Date getDiningBeginTime() {
        return diningBeginTime;
    }

    public void setDiningBeginTime(Date diningBeginTime) {
        this.diningBeginTime = diningBeginTime;
    }

    public Date getDiningEndTime() {
        return diningEndTime;
    }

    public void setDiningEndTime(Date diningEndTime) {
        this.diningEndTime = diningEndTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", firstUserId='" + firstUserId + '\'' +
                ", secondUserId='" + secondUserId + '\'' +
                ", restaurantId=" + restaurantId +
                ", diningBeginTime=" + diningBeginTime +
                ", diningEndTime=" + diningEndTime +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }
}
