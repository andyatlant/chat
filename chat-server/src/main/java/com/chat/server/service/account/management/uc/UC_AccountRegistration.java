package com.chat.server.service.account.management.uc;

import com.chat.common.ActionResult;
import com.chat.common.dao.AccountDao;
import com.chat.common.entity.Account;
import com.chat.common.entity.AccountStatusEnum;
import com.chat.server.service.account.management.AccountFieldsFormatValidator;
import com.chat.server.service.account.management.AccountRegistrationInput;

/**
 *
 */
public class UC_AccountRegistration extends AbstractAccountUC {


    public ActionResult register(AccountRegistrationInput input) {

        // 1.1 validate fields format(name, e-mail, login, password etc)
        ActionResult result = validate(input);
        if (result.isNotSuccess()) {
            return result;
        }
        // 1.2 check e-mail existing - error if exists
        result = checkEmailExisting(input.getEmail());
        if (result.isNotSuccess()) {
            return result;
        }
        // 1.3 check login existing - error if exists
        result = checkLoginExisting(input.getLogin());
        if (result.isNotSuccess()) {
            return result;
        }

        // 1.4 create user object with temporary status, registration time and generated CODE
        Account account = createAccount(input);

        // 1.5 save user
        ActionResult<Account> saveResult = saveAccount(account);
        if (saveResult.isNotSuccess()) {
            return saveResult;
        }
        account = saveResult.getOutputValue();

        // 1.6 generate unique String CODE for user
        ActionResult<String> codeResult = generateConfirmationCode(account);
        if (codeResult.isNotSuccess()) {
            return codeResult;
        }
        String confirmationCode = codeResult.getOutputValue();
        // 1.7 generate link to confirm user's e-mail with generated CODE

        // 1.8 send message to user's e-mail with generated link

        return null;
    }

    private ActionResult<String> generateConfirmationCode(Account account) {
        return getConfirmationService().generateConfirmationCode(account.getId());
    }

    private ActionResult<Account> saveAccount(Account account) {
        return getAccountDao().saveAccount(account);
    }


    private Account createAccount(AccountRegistrationInput input) {
        Account account = new Account();
        account.setEmail(input.getEmail());
        account.setUserName(input.getUserName());
        account.setLogin(input.getLogin());
        account.setPassword(input.getPassword());
        account.setStatus(AccountStatusEnum.NOT_CONFIRMED);
        return account;
    }

    private ActionResult validate(AccountRegistrationInput input) {

        ActionResult result = AccountFieldsFormatValidator.LOGIN_VALIDATOR.validate(input.getLogin());
        if (result.isNotSuccess()) {
            return result;
        }
        result = AccountFieldsFormatValidator.PASSWORD_VALIDATOR.validate(input.getPassword());
        if (result.isNotSuccess()) {
            return result;
        }
        result = AccountFieldsFormatValidator.USER_NAME_VALIDATOR.validate(input.getUserName());
        if (result.isNotSuccess()) {
            return result;
        }
        result = AccountFieldsFormatValidator.EMAIL_VALIDATOR.validate(input.getEmail());
        return result;
    }

    private ActionResult checkEmailExisting(String email) {
        Account account = getAccountDao().getAccountByEmail(email);
        ActionResult result = new ActionResult();
        if (account == null) {
            result.setSuccess(true);

        } else {
            result.setSuccess(false);
            result.setMessage("User with email (" + email + ") already exists");
        }
        return result;
    }

    private ActionResult checkLoginExisting(String login) {
        Account account = getAccountDao().getAccountByLogin(login);
        ActionResult result = new ActionResult();
        if (account == null) {
            result.setSuccess(true);

        } else {
            result.setSuccess(false);
            result.setMessage("User with login (" + login + ") already exists");
        }
        return result;
    }
}