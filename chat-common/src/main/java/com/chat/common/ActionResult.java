package com.chat.common;

/**
 * Result of any actions with detailed message in case of error or maybe success
 */
public class ActionResult {
    private boolean success;
    private String message;

    public ActionResult() {
    }

    public ActionResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
