package com.zeek.learnspringwebflux.client;

import com.zeek.learnspringwebflux.domain.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * @ClassName Client
 * @Description
 * @Author liweibo
 * @Date 2020/10/11 4:55 下午
 * @Version v1.0
 **/
public class Client {

    public static void main(String[] args) {

        // 调用服务地址
        WebClient webClient = WebClient.create("http://localhost:57806");

        // 根据id查询
        String id = "1";
        User userResult = webClient.get().uri("/users/{id}", id).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(User.class).block();

        System.out.println(userResult);

        // 查询所有
        Flux<User> results = webClient.get().uri("/users").accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(User.class);
        results.map(user -> user.getName())
                .buffer().doOnNext(System.out::println).blockFirst();
    }
}
