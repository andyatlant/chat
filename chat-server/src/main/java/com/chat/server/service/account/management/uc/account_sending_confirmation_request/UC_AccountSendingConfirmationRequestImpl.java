package com.chat.server.service.account.management.uc.account_sending_confirmation_request;

import com.chat.common.ActionResult;
import com.chat.common.entity.Account;
import com.chat.server.service.account.management.uc.AbstractAccountUC;


public class UC_AccountSendingConfirmationRequestImpl extends AbstractAccountUC
        implements UC_AccountSendingConfirmationRequest {

    private static final String MESSAGE_TEMPLATE =  "account_sending_confirmation_request.message.ftl";
    private static final String TITLE_TEMPLATE =  "account_sending_confirmation_request.title.ftl";

    @Override
    public ActionResult<String> sendConfirmationRequest(Account account) {
        // 1. generate unique String CODE for user
        ActionResult<String> codeResult = generateConfirmationCode(account);
        if (codeResult.isNotSuccess()) {
            return codeResult;
        }
        String confirmationCode = codeResult.getOutputValue();
        // 2 generate link to confirm user's e-mail with generated CODE
        ActionResult<String> linkResult = generateConfirmationLink(confirmationCode);
        if (linkResult.isNotSuccess()) {
            return linkResult;
        }
        String confirmationLink = linkResult.getOutputValue();
        // 3. send message to user's e-mail with generated link
        ActionResult<String> sendMessageResult = sendMessage(account, confirmationLink);
        if (sendMessageResult.isNotSuccess()) {
            return sendMessageResult;
        }
        return new ActionResult<String>(true, null);
    }


    private ActionResult<String> sendMessage(Account account, String confirmationLink) {
        //TODO null
        getEmailService().sendMessage(account.getEmail(), null, null);
        return null;
    }

    private ActionResult<String> generateConfirmationCode(Account account) {
        return getConfirmationService().generateConfirmationCode(account.getId());
    }

    private ActionResult<String> generateConfirmationLink(String confirmationCode) {
        return getLinkService().generateAccountConfirmationLink(confirmationCode);
    }
}
