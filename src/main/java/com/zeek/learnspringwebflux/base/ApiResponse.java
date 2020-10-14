package com.zeek.learnspringwebflux.base;

/**
 * @ClassName ApiResponse
 * @Description
 * @Author liweibo
 * @Date 2020/10/14 11:35 下午
 * @Version v1.0
 **/
public class ApiResponse {

    public ApiResponse() {

    }

    public ApiResponse(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
