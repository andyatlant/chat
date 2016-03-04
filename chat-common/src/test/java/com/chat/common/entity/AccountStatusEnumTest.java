package com.chat.common.entity;


import org.junit.Test;


import static org.junit.Assert.*;

public class AccountStatusEnumTest {

    // TODO
// I Don't understend
    @Test(expected = IllegalArgumentException.class)
    public void testGet_IllegalArgumentException() throws Exception {
        assertEquals("", AccountStatusEnum.get("Hi"));
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