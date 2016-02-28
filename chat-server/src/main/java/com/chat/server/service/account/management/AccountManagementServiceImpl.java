package com.chat.server.service.account.management;

import com.chat.common.ActionResult;
import com.chat.server.service.account.management.uc.UC_AccountRegistration;

/**
 *
 */
public class AccountManagementServiceImpl implements AccountManagementService {
   private final UC_AccountRegistration uc_accountRegistration = new UC_AccountRegistration();

    @Override
    public ActionResult register(AccountRegistrationInput input) {
        return uc_accountRegistration.register(input);
    }
}
