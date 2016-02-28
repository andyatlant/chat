package com.chat.common.validator;

import com.chat.common.ActionResult;

/**
 *
 */
public interface Validator<T>{
    public ActionResult validate(T value);
}
