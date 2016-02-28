package com.chat.server.service.account.management;

import com.chat.common.ActionResult;
import com.chat.common.validator.Validator;
import org.apache.commons.lang3.StringUtils;


/**
 *
 */
public class AccountFieldsFormatValidator {

    // Class Validator$1 implements Validator
    public static final Validator<String> USER_NAME_VALIDATOR = new Validator<String>() {
        @Override
        public ActionResult validate(String userName) {
            // 1.1 Check length (must be between 3 and 30)
            ActionResult actionResult = new ActionResult();
            if (StringUtils.isBlank(userName)) {
                actionResult.setSuccess(false);
                actionResult.setMessage("User name must not be empty");
            } else {
                userName = userName.trim();
                if (userName.length() < 3) {
                    actionResult.setSuccess(false);
                    actionResult.setMessage("User name must contain more than 3 characters");
                } else if (userName.length() > 20) {
                    actionResult.setSuccess(false);
                    actionResult.setMessage("User name must contain maximum 20 characters");
                } else {
                    actionResult.setSuccess(true);
                }
            }
            return actionResult;
        }
    };

    /**
     * 1.1 Check length (must be between 8 and 20 <br/>
     * 1.2 Must contain at least one capital letter<br/>
     * 1.3 Must contain at least one digit<br/>
     * 1.4 Must not contain spaces
     */
    public static final Validator<String> PASSWORD_VALIDATOR = new Validator<String>() {
        public static final int MIN_LENGTH = 8;
        public static final int MAX_LENGTH = 20;
        private final String SPACE_PATTERN = "\\s";

        /*
        * (			# Начало группы
  (?=.*\d)		#   должен содержать хотя бы одну цифру
  (?=.*[a-z])	#   должен содержать хотябы одну букву в нижнем регистре
  (?=.*[A-Z])	#   должен содержать хотябы одну букву в верхнем регистре
  (?=.*[@#$%])	#   должен содержать один специальный символ из "@#$%"
  .		        #     любое совпадение с предыдущими условиями
  {8,20}	        #     длина от 8 до 20 символов
)			# Конец группы
        * */

        private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,20})";

        @Override
        public ActionResult validate(String password) {
            ActionResult actionResult = new ActionResult();
            if (StringUtils.isBlank(password)) {
                actionResult.setSuccess(false);
                actionResult.setMessage("Password must not be empty");
            } else {
                if (password.matches(SPACE_PATTERN)) {
                    actionResult.setSuccess(false);
                    actionResult.setMessage("Password must not contain spaces");
                } else if (password.length() < MIN_LENGTH) {
                    actionResult.setSuccess(false);
                    actionResult.setMessage("Password must contain more than " + MIN_LENGTH + " characters");
                } else if (password.length() > MAX_LENGTH) {
                    actionResult.setSuccess(false);
                    actionResult.setMessage("Password must contain maximum " + MAX_LENGTH + " characters");
                } else if (password.matches(PASSWORD_PATTERN)) {
                    actionResult.setSuccess(true);
                } else {
                    actionResult.setSuccess(false);
                    actionResult.setMessage("Password Must be contain one number " +
                            "and both lower and uppercase letters");
                }
            }
            return actionResult;
        }

    };

    public static final Validator<String> EMAIL_VALIDATOR = new Validator<String>() {
        public static final int MIN_LENGTH = 5;
        public static final int MAX_LENGTH = 30;
        private static final String EMAIL_PATTERN = "(^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*" +
                "@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$)";

        @Override
        public ActionResult validate(String email) {
            ActionResult actionResult = new ActionResult();
            if (StringUtils.isBlank(email)) {
                actionResult.setSuccess(false);
                actionResult.setMessage("E-mail not be empty");
            } else if (!email.matches(EMAIL_PATTERN)) {
                actionResult.setSuccess(false);
                actionResult.setMessage("Not correct an e-mail");
            } else {
                actionResult.setSuccess(true);
            }
            return actionResult;
        }
    };

    public static final Validator<String> LOGIN_VALIDATOR = new Validator<String>() {
        @Override
        public ActionResult validate(String login) {
            ActionResult actionResult = new ActionResult();
            if (StringUtils.isBlank(login)) {
                actionResult.setSuccess(false);
                actionResult.setMessage("Login must not be empty");
            } else {
                login = login.trim();
                if (login.length() < 3) {
                    actionResult.setSuccess(false);
                    actionResult.setMessage("Login must contain more than 3 characters");
                } else if (login.length() > 20) {
                    actionResult.setSuccess(false);
                    actionResult.setMessage("Login must contain maximum 20 characters");
                } else {
                    actionResult.setSuccess(true);
                }
            }
            return actionResult;
        }
    };
}