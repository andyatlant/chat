package com.chat.common.dao;

import com.chat.common.ActionResult;
import com.chat.common.entity.Account;

/**
 *
 */
public interface AccountDao {
    public Account getAccountByEmail(String email);

    public Account getAccountByLogin(String login);

    public ActionResult<Account> saveAccount(Account account);
}
