package com.chat.server.service.account.management.uc;

import com.chat.common.ActionResult;
import com.chat.common.dao.AccountDao;
import com.chat.common.entity.Account;
import com.chat.server.service.account.management.AccountRegistrationInput;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.*;


/**
 *
 */
public class UC_AccountRegistration_Test {
    @Test
    public void checkEmailExistingTest_emailExists() {
        // create account
        Account account = new Account();
        account.setEmail("andyatlant@gmail.com");
        account.setLogin("andyatlant");
        account.setPassword("Andyatlant123");
        account.setUserName("Andrei");
        // create mock for AccountDao
        AccountDao accountDaoTest = Mockito.mock(AccountDao.class);
        Mockito.when(accountDaoTest.getAccountByEmail("andyatlant@gmail.com")).thenReturn(account);


        UC_AccountRegistration uc_accountRegistration = new UC_AccountRegistration();
        uc_accountRegistration.setAccountDao(accountDaoTest);
        // create account registration input
        AccountRegistrationInput accountInput = new AccountRegistrationInput();
        accountInput.setEmail("andyatlant@gmail.com");
        accountInput.setLogin("andyatlant");
        accountInput.setPassword("Andyatlant123");
        accountInput.setUserName("Andrei");

        // checkEmailExisting
        assertFalse(uc_accountRegistration.register(accountInput).isSuccess());
        Assert.assertEquals("User with email (andyatlant@gmail.com) already exists", uc_accountRegistration.register(accountInput).getMessage());

    }

    public void checkEmailExistingTest_emailNotExists() {
        // create account
        Account account = new Account();
        account.setEmail("andy@gmail.com");
        account.setLogin("andyatlant");
        account.setPassword("Andyatlant123");
        account.setUserName("Andrei");
        // create mock for AccountDao
        AccountDao accountDaoTest = Mockito.mock(AccountDao.class);
        Mockito.when(accountDaoTest.getAccountByEmail("andyatlant@gmail.com")).thenReturn(account);


        UC_AccountRegistration uc_accountRegistration = new UC_AccountRegistration();
        uc_accountRegistration.setAccountDao(accountDaoTest);
        // create account registration input
        AccountRegistrationInput accountInput = new AccountRegistrationInput();
        accountInput.setEmail("andyatlant@gmail.com");
        accountInput.setLogin("andyatlant");
        accountInput.setPassword("Andyatlant123");
        accountInput.setUserName("Andrei");

        // checkEmailExisting
        assertTrue(uc_accountRegistration.register(accountInput).isSuccess());
        Assert.assertEquals(null, uc_accountRegistration.register(accountInput).getMessage());
    }

    @Test
    public void checkLoginExistingTest_emailExists() {
        // create account
        Account account = new Account();
        account.setEmail("andyatlant@gmail.com");
        account.setLogin("andyatlant");
        account.setPassword("Andyatlant123");
        account.setUserName("Andrei");
        // create mock for AccountDao
        AccountDao accountDaoTest = Mockito.mock(AccountDao.class);
        Mockito.when(accountDaoTest.getAccountByLogin("andyatlant")).thenReturn(account);


        UC_AccountRegistration uc_accountRegistration = new UC_AccountRegistration();
        uc_accountRegistration.setAccountDao(accountDaoTest);
        // create account registration input
        AccountRegistrationInput accountInput = new AccountRegistrationInput();
        accountInput.setEmail("andyatlant@gmail.com");
        accountInput.setLogin("andyatlant");
        accountInput.setPassword("Andyatlant123");
        accountInput.setUserName("Andrei");

        // checkEmailExisting
        assertFalse(uc_accountRegistration.register(accountInput).isSuccess());
        Assert.assertEquals("User with login (andyatlant) already exists", uc_accountRegistration.register(accountInput).getMessage());

    }

    public void checkEmailLoginTest_emailNotExists() {
        // create account
        Account account = new Account();
        account.setEmail("andyatlant@gmail.com");
        account.setLogin("andyatlant");
        account.setPassword("Andyatlant123");
        account.setUserName("Andrei");
        // create mock for AccountDao
        AccountDao accountDaoTest = Mockito.mock(AccountDao.class);
        Mockito.when(accountDaoTest.getAccountByEmail("andyatlant")).thenReturn(account);


        UC_AccountRegistration uc_accountRegistration = new UC_AccountRegistration();
        uc_accountRegistration.setAccountDao(accountDaoTest);
        // create account registration input
        AccountRegistrationInput accountInput = new AccountRegistrationInput();
        accountInput.setEmail("andyatlant@gmail.com");
        accountInput.setLogin("andy");
        accountInput.setPassword("Andyatlant123");
        accountInput.setUserName("Andrei");

        // checkEmailExisting
        assertTrue(uc_accountRegistration.register(accountInput).isSuccess());
        Assert.assertEquals(null, uc_accountRegistration.register(accountInput).getMessage());
    }

}
