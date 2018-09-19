package com.luckyhit.domain;

public enum  OrderStatus {
    Pending,
    Done;

    public static OrderStatus getEnum(short value) {
        return OrderStatus.values()[value];
    }

    public short getValue() {
        return (short)this.ordinal();
    }
}
