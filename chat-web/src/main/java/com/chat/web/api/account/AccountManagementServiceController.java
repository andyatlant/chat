package com.chat.web.api.account;

import com.chat.common.ActionResult;
import com.chat.server.service.account.management.AccountManagementService;
import com.chat.server.service.account.management.AccountRegistrationInput;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Controller for AMS based on REST API
 */
@RestController
public class AccountManagementServiceController {

    private AccountManagementService ams;

    @RequestMapping(value = "/api/ams/register",method = RequestMethod.POST)
    public ActionResult register (@Valid @RequestBody AccountRegistrationInput input){
        return ams.register(input);
    }


}
