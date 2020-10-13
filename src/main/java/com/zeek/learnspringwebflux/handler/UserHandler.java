package com.zeek.learnspringwebflux.handler;

import com.zeek.learnspringwebflux.domain.User;
import com.zeek.learnspringwebflux.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * @ClassName UserHandler
 * @Description
 * @Author liweibo
 * @Date 2020/10/11 4:14 下午
 * @Version v1.0
 **/
public class UserHandler {

    private final UserService userService ;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    // 根据id查询
    public Mono<ServerResponse> getUserById(ServerRequest request) {
        // 获取id值
        int userId = Integer.parseInt(request.pathVariable("id"));

        // 空值处理
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        // 调用service方法得到数据
        Mono<User> userMon = this.userService.getUserById(userId);

        // 把userMono进行转换返回
        // 使用Reactor操作符flatMap fixme ??????
        return userMon.flatMap(user -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(fromObject(user)))
                .switchIfEmpty(notFound);
    }

    // 查询所有
    public Mono<ServerResponse> getAllUsers(ServerRequest request) {
        Flux<User> users = this.userService.getAllUser();

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(users, User.class);
    }

    // 添加
    public Mono<ServerResponse> saveUser(ServerRequest request) {

        // 得到User对象
        Mono<User> userMono = request.bodyToMono(User.class);

        // fixme ?????
        return ServerResponse.ok().build(this.userService.saveUserInfo(userMono));

    }
}
