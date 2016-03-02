package com.chat.common.validator;

import com.chat.common.ActionResult;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompositeValidatorTest {

    @Test
    public void testValidate() throws Exception {
        Validator<String> v1 = new Validator<String>() {
            @Override
            public ActionResult validate(String value) {
                return null;
            }
        } ;

        Validator<String> v2 = new Validator<String>() {
            @Override
            public ActionResult validate(String value) {
                return null;
            }
        } ;
CompositeValidator<String> compositeValidator = new CompositeValidator<String>(v1,v2);

    }
}