package com.chat.server.service.account.management.uc;

import com.chat.common.confirmation.ConfirmationService;
import com.chat.common.dao.AccountDao;
import com.chat.common.notification.email.EmailService;
import com.chat.common.notification.link.LinkService;

/**
 *
 */
public abstract class AbstractAccountUC {

    private ConfirmationService confirmationService;
    private AccountDao accountDao;
    private EmailService emailService;
    private LinkService linkService;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public ConfirmationService getConfirmationService() {
        return confirmationService;
    }

    public void setConfirmationService(ConfirmationService confirmationService) {
        this.confirmationService = confirmationService;
    }

    public EmailService getEmailService() {
        return emailService;
    }

    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    public LinkService getLinkService() {
        return linkService;
    }

    public void setLinkService(LinkService linkService) {
        this.linkService = linkService;
    }
}
