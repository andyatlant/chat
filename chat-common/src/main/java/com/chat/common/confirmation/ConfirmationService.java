package com.chat.common.confirmation;

import com.chat.common.ActionResult;

/**
 *
 */
public interface ConfirmationService {

    public ActionResult<String> generateConfirmationCode(long entityId);

    public ActionResult<Long> checkConfirmationCode(String confirmationCode);

}
