package com.zeek.learnspringwebflux.config;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static reactor.core.publisher.Flux.just;

import java.net.URI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.zeek.learnspringwebflux.domain.User;

import reactor.core.publisher.Mono;

/**
 * @ClassName RouterFunctionConfig
 * @Description
 * @Author liweibo
 * @Date 2020/9/26 5:46 下午
 * @Version v1.0
 **/
@Configuration
public class RouterFunctionConfig {

    @Bean
    public RouterFunction<?> helloRouterFunction() {

        User user = new User();
        user.setAge(18);
        user.setGender("man");
        user.setName("zhangsan");
        Mono<User> userMono = Mono.just(user);

        return route(GET("/hello"),
                        serverRequest -> ok().body(just("Hello World"), String.class))
               .andRoute(GET("/bye"),
                        serverRequest -> ok().body(just("See ya!"), String.class))
               .andRoute(GET("/test"),
                        serverRequest -> ServerResponse.created(URI.create("http://localhost:8081/testtest")).body(userMono, User.class));
    }
}
