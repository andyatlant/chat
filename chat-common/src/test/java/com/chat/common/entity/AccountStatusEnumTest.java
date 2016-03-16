package com.chat.common.entity;


import org.junit.Test;


import static org.junit.Assert.*;

public class AccountStatusEnumTest {

    @Test(expected = IllegalArgumentException.class)
    public void testGet_IllegalArgumentException() throws Exception {
        try {
            AccountStatusEnum.get("Hi");
        } catch (IllegalArgumentException e) {
            assertEquals("Unexpected value [Hi]. Available values:  NotConfirmed Confirmed Blocked ", e.getMessage());
            throw e;
        }
    }

    @Test
    public void testGet_NotConfirmed() {
        assertEquals(AccountStatusEnum.NOT_CONFIRMED, AccountStatusEnum.get("NotConfirmed"));
    }

    @Test
    public void testGet_Confirmed() {
        assertEquals(AccountStatusEnum.CONFIRMED, AccountStatusEnum.get("Confirmed"));
    }

    @Test
    public void testGet_Blocked() {
        assertEquals(AccountStatusEnum.BLOCKED, AccountStatusEnum.get("Blocked"));
    }


}