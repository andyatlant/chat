package com.chat.server.service.account.management.uc;

import com.chat.common.ActionResult;
import com.chat.common.dao.AccountDao;
import com.chat.common.entity.Account;
import com.chat.server.service.account.management.AccountRegistrationInput;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.*;


/**
 *
 */
public class UC_AccountRegistration_Test {

    private void register(String email, String login, String password, String userName,
                          boolean success, String message) {
        AccountRegistrationInput accountInput = new AccountRegistrationInput();
        accountInput.setEmail(email);
        accountInput.setLogin(login);
        accountInput.setPassword(password);
        accountInput.setUserName(userName);
        UC_AccountRegistration uc_accountRegistration = new UC_AccountRegistration();
        ActionResult actionResult = uc_accountRegistration.register(accountInput);
        assertEquals(success, actionResult.isSuccess());
        if(message!=null){
            assertEquals(message, actionResult.getMessage());
        }
    }


    @Test
    public void registerTest_validateFieldsFormatCheckLogin() {
        register("andyatlant@gmail.com", "an", "Andyatlant123", "Andrei",
                false, "Login must contain more than 3 characters");
    }

    @Test
    public void registerTest_validateFieldsFormatCheckPassword() {
        register("andyatlant@gmail.com", "andy", "123456789", "Andrei",
                false, "Password Must be contain one number and both lower and uppercase letters");
    }

    @Test
    public void registerTest_validateFieldsFormatCheckUserName() {
        register("andyatlant@gmail.com", "andy", "An123456789", "",
                false, "User name must not be empty");
    }

    @Test
    public void registerTest_validateFieldsFormatCheckEmail() {
        register("andyatlant@.gmail.com", "andy", "An123456789", "Andrey",
                false, "Not correct an e-mail");
    }

    @Test
    public void registerTest_checkEmailExisting() {
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
        accountInput.setLogin("andyatlant2");
        accountInput.setPassword("Andyatlant123");
        accountInput.setUserName("Andrei");
        // checkEmailExisting
        assertFalse(uc_accountRegistration.register(accountInput).isSuccess());
    }

    // TODO Fix test -> check email and login
    // TODO Refactor remove duplicate
    @Test
    public void registerTest_checkLoginExisting() {
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
    }

//    @Test
//    public void checkEmailLoginTest_ifLoginNotExistsInDB() {
//        // create account
//        Account account = new Account();
//        account.setEmail("andyatlant@gmail.com");
//        account.setLogin("andyatlant");
//        account.setPassword("Andyatlant123");
//        account.setUserName("Andrei");
//        // create mock for AccountDao
//        AccountDao accountDaoTest = Mockito.mock(AccountDao.class);
//        Mockito.when(accountDaoTest.getAccountByEmail("andyatlant")).thenReturn(account);
//
//
//        UC_AccountRegistration uc_accountRegistration = new UC_AccountRegistration();
//        uc_accountRegistration.setAccountDao(accountDaoTest);
//        // create account registration input
//        AccountRegistrationInput accountInput = new AccountRegistrationInput();
//        accountInput.setEmail("andyatlant@gmail.com");
//        accountInput.setLogin("andy");
//        accountInput.setPassword("Andyatlant123");
//        accountInput.setUserName("Andrei");
//
//        // checkEmailExisting
//  //      assertTrue(uc_accountRegistration.register(accountInput).isSuccess());
//      //  Assert.assertEquals(null, uc_accountRegistration.register(accountInput).getMessage());
//    }

}
