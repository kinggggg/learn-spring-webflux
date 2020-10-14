package com.zeek.learnspringwebflux.controller;

import com.zeek.learnspringwebflux.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName HelloController
 * @Description
 * @Author liweibo
 * @Date 2020/9/26 5:21 下午
 * @Version v1.0
 **/
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/helloworld/{flag}")
    public List<String> list(@PathVariable boolean flag) {

        List<String> list = helloService.getList(flag);

        return list;

    }
}
