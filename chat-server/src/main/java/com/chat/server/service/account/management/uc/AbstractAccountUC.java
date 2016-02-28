package com.chat.server.service.account.management.uc;

import com.chat.common.dao.AccountDao;

/**
 *
 */
public abstract class AbstractAccountUC {

    private AccountDao accountDao;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
