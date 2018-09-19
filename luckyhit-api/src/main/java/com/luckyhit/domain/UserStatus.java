package com.luckyhit.domain;

public enum UserStatus {
    Online,
    Pending,
    Done;

    public static UserStatus getEnum(short value) {
        return UserStatus.values()[value];
    }

    public short getValue() {
        return (short)this.ordinal();
    }
}
