package com.zeek.learnspringwebflux.service;

import com.zeek.learnspringwebflux.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author: liweibo
 * @since: 2020-10-11 3:47 下午
 */
public interface UserService {

    // 根据id查询用户
    Mono<User> getUserById(int id);

    // 查询所有的用户
    Flux<User> getAllUser();

    // 添加用户
    Mono<Void> saveUserInfo(Mono<User> user);
}
