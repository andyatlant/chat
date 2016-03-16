package com.chat.server.service.account.management.uc.account_sending_confirmation_request;

import com.chat.common.ActionResult;
import com.chat.common.entity.Account;

/**
 * Use case: Account sending confirmation request
 */
public interface UC_AccountSendingConfirmationRequest {
    /**
     * 1. generate unique String CODE for user
     * 2. generate link to confirm user's e-mail with generated CODE
     * 3. send message to user's e-mail with generated link
     */
    public ActionResult<String> sendConfirmationRequest(Account account);

}
