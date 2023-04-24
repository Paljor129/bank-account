package com.societegenerale.bankaccountsystem.application.exception;

public class ParameterException extends IllegalArgumentException{
    private static final long serialVersionUID = 1L;

    private String parameterName;

    public ParameterException() {
        super();
    }

    public ParameterException(String pMessage) {
        super(pMessage);
    }

    public ParameterException(String pMessage, String pParameterName) {
        super(pMessage);
        this.parameterName = pParameterName;
    }

    public ParameterException(Throwable pCause) {
        super(pCause);
    }

    public ParameterException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);
    }

    public String getParameterName() {
        return this.parameterName;
    }

    public void setParameterName(String pParamterName) {
        this.parameterName = pParamterName;
    }

}
