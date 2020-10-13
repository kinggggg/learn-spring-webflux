package com.zeek.learnspringwebflux.controller;

import com.zeek.learnspringwebflux.domain.User;
import com.zeek.learnspringwebflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @ClassName UserController
 * @Description
 * @Author liweibo
 * @Date 2020/10/11 3:59 下午
 * @Version v1.0
 **/
@RestController
public class UserController {

    // 注入service
    @Autowired
    private UserService userService;

    // id查询
    @GetMapping("/user/{id}")
    public Mono<User> getUserId(@PathVariable int id) {
        return userService.getUserById(id);
    }

    // 查询所有
    @GetMapping("/users")
    public Flux<User> getUsers() {
        return userService.getAllUser();
    }

    // 添加
    @PostMapping("/user")
    public Mono<Void> saveUser(@RequestBody User user) {
        Mono<User> userMono = Mono.just(user);
        return userService.saveUserInfo(userMono);
    }
}
