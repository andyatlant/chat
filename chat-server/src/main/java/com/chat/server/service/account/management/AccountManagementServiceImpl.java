package com.chat.server.service.account.management;

import com.chat.common.ActionResult;

/**
 *
 */
public class AccountManagementServiceImpl implements AccountManagementService {


    @Override
    public ActionResult register(AccountRegistrationInput input) {
        // 1.1 validate fields format(name, e-mail, login, password etc)


        // 1.2 check e-mail existing - error if exists
        // 1.3 check login existing - error if exists
        // 1.4 generate unique String CODE for user
        // 1.5 create user object with temporary status, registration time and generated CODE
        // 1.6 save user
        // 1.7 generate link to confirm user's e-mail with generated CODE
        // 1.8 send message to user's e-mail with generated link

        return null;
    }
}
