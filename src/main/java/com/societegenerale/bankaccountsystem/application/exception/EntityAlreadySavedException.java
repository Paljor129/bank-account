package com.societegenerale.bankaccountsystem.application.exception;

public class EntityAlreadySavedException extends AbstractFunctionalException {
	private static final long serialVersionUID = 1L;

	public EntityAlreadySavedException() {
		super();
	}

	public EntityAlreadySavedException(String message) {
		super(message);
	}

	public EntityAlreadySavedException(Throwable cause) {
		super(cause);
	}

	public EntityAlreadySavedException(String message, Throwable cause) {
		super(message, cause);
	}

}
