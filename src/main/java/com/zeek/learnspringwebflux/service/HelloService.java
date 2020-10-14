package com.zeek.learnspringwebflux.service;

import com.zeek.learnspringwebflux.annotation.ApiCallMonitor;
import com.zeek.learnspringwebflux.domain.User;

import java.util.List;

/**
 * @ClassName HelloService
 * @Description
 * @Author liweibo
 * @Date 2020/9/26 5:22 下午
 * @Version v1.0
 **/
public interface HelloService {

    List<String> getList(boolean flag);

    List<User> getUsers();
}
