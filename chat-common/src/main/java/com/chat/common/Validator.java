package com.chat.common;

/**
 *
 */
public interface Validator<T>{
    public ActionResult validate(T value);
}
