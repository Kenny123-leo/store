package com.cy.store.service.ex;

/* 验证码找不到的异常 */
public class ValidCodeNotException extends ServiceException{
    public ValidCodeNotException() {
        super();
    }

    public ValidCodeNotException(String message) {
        super(message);
    }

    public ValidCodeNotException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidCodeNotException(Throwable cause) {
        super(cause);
    }

    protected ValidCodeNotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
