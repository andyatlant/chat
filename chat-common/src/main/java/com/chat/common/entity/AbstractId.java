package com.chat.common.entity;

/**
 *
 */
public abstract class AbstractId {
    private long id;

    public AbstractId() {
    }

    public AbstractId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
