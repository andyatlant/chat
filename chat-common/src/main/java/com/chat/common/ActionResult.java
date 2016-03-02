package com.chat.common;

/**
 * Result of any actions with detailed message in case of error or maybe success
 */
public class ActionResult<T> {
    private boolean success;
    private String message;
    private T outputValue;

    public ActionResult() {
        this(false, null);
    }

    public ActionResult(boolean success, String message) {
        this(success, message, null);
    }

    public ActionResult(boolean success, String message, T outputValue) {
        this.success = success;
        this.message = message;
        this.outputValue = outputValue;
    }

    public T getOutputValue() {
        return outputValue;
    }

    public void setOutputValue(T outputValue) {
        this.outputValue = outputValue;
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

    public boolean isNotSuccess() {
        return !success;
    }
}
