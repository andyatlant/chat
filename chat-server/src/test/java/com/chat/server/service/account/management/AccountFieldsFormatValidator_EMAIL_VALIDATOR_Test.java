package com.chat.server.service.account.management;

import com.chat.common.ActionResult;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 */
public class AccountFieldsFormatValidator_EMAIL_VALIDATOR_Test {

    /**
     * Add null in args
     * isSuccess() -> false
     * getMessage -> E-mail not be empty
     */
    @Test
    public void testValidateInputNull() {
        ActionResult result = AccountFieldsFormatValidator.EMAIL_VALIDATOR.validate(null);
        assertFalse(result.isSuccess());
        assertEquals("E-mail not be empty", result.getMessage());
    }

    /**
     * Add incorrect emails
     * isSuccess() -> false
     * getMessage -> Not correct an e-mail
     */
    @Test
    public void testValidateInputIncorrectEmail() {
        String[] emails = new String[]{
                "j4web", "j4web@.com.my",
                "j4web123@gmail.a", "j4web123@.com",
                "j4web123@.com.com", ".j4web@j4web.ru",
                "j4web()*@gmail.com", "j4web@%*.com",
                "j4web..2002@gmail.com", "j4web.@gmail.com",
                "j4web@j4web@gmail.com", "j4web@gmail.com.1a"};
        for (String email : emails) {
            ActionResult result = AccountFieldsFormatValidator.EMAIL_VALIDATOR.validate(email);
            assertFalse(result.isSuccess());
            assertEquals("Not correct an e-mail", result.getMessage());
        }
    }

    /**
     * Add Correct emails
     * isSuccess() -> true
     * getMessage -> null
     */
    @Test
    public void testValidateInputCorrectEmail() {
        String[] emails = new String[]{
                "andytlant@gmail.com", "and-atlant@mail.ru",
                "andy-atlant@mail.spb.ru", "Andrey.Tsirukhin@mail.com"};
        for (String email : emails) {
            ActionResult result = AccountFieldsFormatValidator.EMAIL_VALIDATOR.validate(email);
            assertTrue(result.isSuccess());
            assertEquals(null, result.getMessage());
        }
    }
}