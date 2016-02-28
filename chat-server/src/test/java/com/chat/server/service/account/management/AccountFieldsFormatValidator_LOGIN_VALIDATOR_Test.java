package com.chat.server.service.account.management;

import com.chat.common.ActionResult;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 *
 */
public class AccountFieldsFormatValidator_LOGIN_VALIDATOR_Test {

    /*
   * Add null in args
   *@return
   * isSuccess() -> false
   * getMessage -> Login must not be empty
   * */
    @Test
    public void testValidateInputNull() {
        ActionResult result = AccountFieldsFormatValidator.LOGIN_VALIDATOR.validate(null);
        assertFalse(result.isSuccess());
        assertEquals("Login must not be empty", result.getMessage());
    }

    /*
    * Add less then 3 characters in args
    *@return
    * isSuccess() -> false
    * getMessage -> Login must contain more than 3 characters
    * */
    @Test
    public void testValidateLessThree() {
        ActionResult result = AccountFieldsFormatValidator.LOGIN_VALIDATOR.validate("12");
        assertFalse(result.isSuccess());
        assertEquals("Login must contain more than 3 characters", result.getMessage());
    }

    /*
  * Add more then twenty characters in args
  *@return
  * isSuccess() -> false
  * getMessage -> Login must contain maximum 20 characters
  * */
    @Test
    public void testValidateMoreThenTwenty() {
        ActionResult result = AccountFieldsFormatValidator.LOGIN_VALIDATOR.validate("1234567891011121314151617181920");
        assertFalse(result.isSuccess());
        assertEquals("Login must contain maximum 20 characters", result.getMessage());
    }

    /*
     * Add between tree and twenty characters in args
     *@return
     * isSuccess() -> true
     * getMessage -> null
     * */
    @Test
    public void testValidateBetweenTreeAndTwenty() {
        ActionResult result = AccountFieldsFormatValidator.LOGIN_VALIDATOR.validate("1234567");
        assertTrue(result.isSuccess());
        assertEquals(null, result.getMessage());
    }

    /*
  * Add empty string in args
  *@return
  * isSuccess() -> false
  * getMessage -> Login must not be empty
  * */
    @Test
    public void testValidateInputEmptyString() {
        ActionResult result = AccountFieldsFormatValidator.LOGIN_VALIDATOR.validate("");
        assertFalse(result.isSuccess());
        assertEquals("Login must not be empty", result.getMessage());
    }

    /*
 * Add five spaces in args
 *@return
 * isSuccess() -> false
 * getMessage -> Login must not be empty
 * */
    @Test
    public void testValidateInputFiveSpaces() {
        ActionResult result = AccountFieldsFormatValidator.LOGIN_VALIDATOR.validate("     ");
        assertFalse(result.isSuccess());
        assertEquals("Login must not be empty", result.getMessage());
    }
}
