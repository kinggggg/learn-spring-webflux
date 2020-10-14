package com.zeek.learnspringwebflux.exception;

/**
 * @ClassName BusinessException
 * @Description
 * @Author liweibo
 * @Date 2020/10/14 11:27 下午
 * @Version v1.0
 **/
public class BusinessException extends RuntimeException {

    private int errorCode;

    private String errorMessage;

    public BusinessException() {

    }

    public BusinessException(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
