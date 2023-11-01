package com.fiuni.sd.exception;

public class UniqueConstraintViolationException extends BaseException {

    private static final long serialVersionUID = 1L;

    public UniqueConstraintViolationException(String message) {
        super(message);
    }
}
