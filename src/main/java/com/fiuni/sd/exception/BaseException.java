package com.fiuni.sd.exception;

public class BaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BaseException(final String message) {
		super(message);
	}
}