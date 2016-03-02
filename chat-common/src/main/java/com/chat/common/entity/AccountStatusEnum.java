package com.chat.common.entity;

/**
 *
 */
public enum AccountStatusEnum {
    NOT_CONFIRMED("NotConfirmed"),
    CONFIRMED("Confirmed"),
    BLOCKED("Blocked");

    private final String value;

    AccountStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AccountStatusEnum get(String value) {
        for (AccountStatusEnum status : values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unexpected value [" + value + "]. " +
                "Available values: " + getValues());
    }

    private static String getValues() {
        String values = " ";
        for (AccountStatusEnum status : values()) {
            values += status.getValue() + " ";
        }
        return values;
    }
}
