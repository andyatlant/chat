package com.chat.common.confirmation;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConfirmationServiceTest {

    // Test cases
    // 1. Test generation CODE for not existing entity ID and checking the CODE
    //    before expiration timestamp.
    //    - Generate CODE for entity ID = 1 (expected: Success, CODE = X1)
    //    - Check CODE = X1 (expected: Success, EntityID = 1)
    // 2. Test generation CODE for not existing entity ID and checking the CODE
    //    after expiration timestamp.
    //    - Generate CODE for entity ID = 2 (expected: Success, CODE = X2)
    //    - Check CODE = X2 (expected: Fail, Message ="Confirmation CODE is expired: X2")
    // 3. Test generation CODE for existing entity ID and checking the CODE
    //    before expiration timestamp.
    //    - Generate CODE for entity ID = 1 (expected: Success, CODE = X3)
    //    - Check CODE = X3 (expected: Success, EntityID = 1)
    //    - Check CODE = X1 (expected: Success, EntityID = 1)
    @Test
    public void testGenerateConfirmationCode() throws Exception {

    }

    @Test
    public void testCheckConfirmationCode() throws Exception {

    }
}