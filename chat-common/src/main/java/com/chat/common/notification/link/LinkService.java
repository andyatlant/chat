package com.chat.common.notification.link;

import com.chat.common.ActionResult;

/**
 *
 */
public interface LinkService {
    public ActionResult<String> generateAccountConfirmationLink(String confirmationCode);
}
