package com.zeek.learnspringwebflux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static reactor.core.publisher.Flux.just;

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

        return route(GET("/hello"),
                serverRequest -> ok().body(just("Hello World"), String.class))
               .andRoute(GET("/bye"),
                serverRequest -> ok().body(just("See ya!"), String.class));
    }
}
