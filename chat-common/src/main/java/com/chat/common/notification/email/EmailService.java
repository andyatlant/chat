package com.chat.common.notification.email;

import com.chat.common.ActionResult;

/**
 *
 */
public interface EmailService {
    public ActionResult<Void> sendMessage(String email, String title, String message);

}
