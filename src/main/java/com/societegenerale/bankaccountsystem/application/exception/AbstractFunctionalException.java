package com.societegenerale.bankaccountsystem.application.exception;

public abstract class AbstractFunctionalException extends Exception {
	private static final long serialVersionUID = 1L;

	public AbstractFunctionalException() {
		super();
	}

	public AbstractFunctionalException(String pMessage) {
		super(pMessage);
	}

	public AbstractFunctionalException(Throwable pCause) {
		super(pCause);
	}

	public AbstractFunctionalException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

}
