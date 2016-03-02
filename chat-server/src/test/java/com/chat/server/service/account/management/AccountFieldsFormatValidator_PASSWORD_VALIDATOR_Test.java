package com.chat.server.service.account.management;

import com.chat.common.ActionResult;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 *
 */
public class AccountFieldsFormatValidator_PASSWORD_VALIDATOR_Test {

    /**
    * Add null in args
    * isSuccess() -> false
    * getMessage -> Password must not be empty
    * */
    @Test
    public void testValidateInputNull() {
        ActionResult result = AccountFieldsFormatValidator.PASSWORD_VALIDATOR.validate(null);
        assertFalse(result.isSuccess());
        assertEquals("Password must not be empty", result.getMessage());
    }

    /**
    * Add less then 8 characters in args
    *@return
    * isSuccess() -> false
    * getMessage -> Password must contain more than 8 characters
    * */
    @Test
    public void testValidateLessEight() {
        ActionResult result = AccountFieldsFormatValidator.PASSWORD_VALIDATOR.validate("124567");
        assertFalse(result.isSuccess());
        assertEquals("Password must contain more than 8 characters", result.getMessage());
    }

    /**
  * Add more then twenty characters in args
  *@return
  * isSuccess() -> false
  * getMessage -> Password must contain maximum 20 characters
  * */
    @Test
    public void testValidateMoreThenTwenty() {
        ActionResult result = AccountFieldsFormatValidator.PASSWORD_VALIDATOR.validate("12568844854545445454545568585");
        assertFalse(result.isSuccess());
        assertEquals("Password must contain maximum 20 characters", result.getMessage());
    }

    /**
     * Add between eight and twenty characters in args
     *@return
     * isSuccess() -> true
     * getMessage -> null
     * */
    @Test
    public void testValidateBetweenEightAndTwenty() {
        ActionResult result = AccountFieldsFormatValidator.PASSWORD_VALIDATOR.validate("A1ASkjlkjVDb2hilDDC");
        assertTrue(result.isSuccess());
        assertEquals(null, result.getMessage());
    }

    /**
  * Add empty string in args
  *@return
  * isSuccess() -> false
  * getMessage -> Password must not be empty
  * */
    @Test
    public void testValidateInputEmptyString() {
        ActionResult result = AccountFieldsFormatValidator.PASSWORD_VALIDATOR.validate("");
        assertFalse(result.isSuccess());
        assertEquals("Password must not be empty", result.getMessage());
    }

    /**
 * Add five spaces in args
 *@return
 * isSuccess() -> false
 * getMessage -> User name must not be empty
 * */
    @Test
    public void testValidateInputFiveSpaces() {
        ActionResult result = AccountFieldsFormatValidator.PASSWORD_VALIDATOR.validate("          ");
        assertFalse(result.isSuccess());
        assertEquals("Password must not be empty", result.getMessage());
    }
    /**
    * Add Uppercase letters in args
    *@return
    * isSuccess() -> false
    * getMessage -> Password Must be contain one number and both lower and uppercase letters
    * */
    @Test
    public void testValidateAddUppercaseLetters() {
        ActionResult result = AccountFieldsFormatValidator.PASSWORD_VALIDATOR.validate("SDFGHJKLWERTI");
        assertFalse(result.isSuccess());
        assertEquals("Password Must be contain one number and both lower and uppercase letters",
                result.getMessage());
    }

    /**
     * Add lower letters in args
     *@return
     * isSuccess() -> false
     * getMessage -> Password Must be contain one number and both lower and uppercase letters
     * */
    @Test
    public void testValidateAddLowerLetters() {
        ActionResult result = AccountFieldsFormatValidator.PASSWORD_VALIDATOR.validate("ghjjhbkjnvklneui");
        assertFalse(result.isSuccess());
        assertEquals("Password Must be contain one number and both lower and uppercase letters",
                result.getMessage());
    }

    /**
     * Add numbers in args
     *@return
     * isSuccess() -> false
     * getMessage -> Password Must be contain one number and both lower and uppercase letters
     * */
    @Test
    public void testValidateAddNumbers() {
        ActionResult result = AccountFieldsFormatValidator.PASSWORD_VALIDATOR.validate("1234567890");
        assertFalse(result.isSuccess());
        assertEquals("Password Must be contain one number and both lower and uppercase letters",
                result.getMessage());
    }
}
