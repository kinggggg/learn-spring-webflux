package com.zeek.learnspringwebflux.service.impl;

import com.zeek.learnspringwebflux.annotation.ApiCallMonitor;
import com.zeek.learnspringwebflux.domain.User;
import com.zeek.learnspringwebflux.exception.BusinessException;
import com.zeek.learnspringwebflux.service.HelloService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName HelloServiceImpl
 * @Description
 * @Author liweibo
 * @Date 2020/10/14 11:19 下午
 * @Version v1.0
 **/
//@ApiCallMonitor
@Service
public class HelloServiceImpl implements HelloService {

    @Override
//    @ApiCallMonitor
    public List<String> getList(boolean flag) {

        if (flag) {
            return Arrays.asList("a", "b", "c");
        } else {
            throw new BusinessException(100, "调用错误");
        }

    }

    @Override
    public List<User> getUsers() {

        List<User> users = Arrays.asList(new User("zhangsan", "男", 20), new User("lisi", "女", 0));

        return users;
    }
}
