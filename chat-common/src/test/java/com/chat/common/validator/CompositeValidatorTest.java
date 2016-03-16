package com.chat.common.validator;

import com.chat.common.ActionResult;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompositeValidatorTest {
    ActionResult actionResult = new ActionResult();
    @Test
    public void testValidate() throws Exception {
      //  ActionResult actionResult = new ActionResult();
        Validator <String> v1 = new Validator<String>() {
            

            @Override
            public ActionResult validate(String value) {
                return actionResult;
            }
        };

        Validator <String> v2 = new Validator<String>() {
            @Override
            public ActionResult validate(String value) {
                return null;
            }
        };
CompositeValidator<String> compositeValidator = new CompositeValidator<String>(v1,v2);

    }
}