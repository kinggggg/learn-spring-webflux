package com.zeek.learnspringwebflux.base;

import com.zeek.learnspringwebflux.exception.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ExceptionHandle
 * @Description
 * @Author liweibo
 * @Date 2020/10/14 11:32 下午
 * @Version v1.0
 **/
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ApiResponse exceptionGet(Exception e){

        if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            System.out.println("业务异常: " + businessException.getErrorMessage());
        }
        System.out.println("全局异常捕获: " + e.getMessage());

        return new ApiResponse("返回客户端信息");

    }
}
