package com.chat.common.validator;

import com.chat.common.ActionResult;
import com.chat.common.validator.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class CompositeValidator<T> implements Validator<T> {
    private final List<Validator<T>> validators = new ArrayList<Validator<T>>();

    public CompositeValidator() {
    }

    public CompositeValidator(Validator<T>... validators) {
        this.validators.addAll(Arrays.asList(validators));
    }

    @Override
    public ActionResult validate(T value) {
        for (Validator<T> validator : validators) {
            ActionResult result = validator.validate(value);
            if (!result.isSuccess()) {
                return result;
            }
        }
        return new ActionResult(true, null);
    }
}