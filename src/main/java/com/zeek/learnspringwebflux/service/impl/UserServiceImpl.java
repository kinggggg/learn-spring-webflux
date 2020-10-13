package com.zeek.learnspringwebflux.service.impl;

import com.zeek.learnspringwebflux.domain.User;
import com.zeek.learnspringwebflux.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author liweibo
 * @Date 2020/10/11 3:50 下午
 * @Version v1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    private final Map<Integer, User> users = new HashMap<>();

    public UserServiceImpl() {

        users.put(1, new User("lucy", "man", 20));
        users.put(2, new User("marry", "woman", 30));
        users.put(3, new User("jack", "woman", 50));

    }

    @Override
    public Mono<User> getUserById(int id) {
        return Mono.justOrEmpty(this.users.get(id));
    }

    @Override
    public Flux<User> getAllUser() {
        return Flux.fromIterable(this.users.values());
    }

    @Override
    public Mono<Void> saveUserInfo(Mono<User> userMono) {
        return userMono.doOnNext(user -> {

            int id = users.size() + 1;
            users.put(id, user);
        }).thenEmpty(Mono.empty()); // ????
    }
}
