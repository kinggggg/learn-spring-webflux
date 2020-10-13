package com.zeek.learnspringwebflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName TestReactor
 * @Description
 * @Author liweibo
 * @Date 2020/10/11 11:34 上午
 * @Version v1.0
 **/
public class TestReactor {

    @Test
    public void createTest() {

        // just方法创建
        Flux.just(1, 2, 3, 4).subscribe(System.out::println); // System.out是一个实例对象，System.out::println是实例方法引用
        Mono.just(1);

        // 数组方法创建
        Integer[] array = {1, 2, 3, 4};
        Flux.fromArray(array);

        // 集合方式创建
        List<Integer> list = Arrays.asList(array);
        Flux.fromIterable(list);


        // 流方式创建
        Stream<Integer> stream = list.stream();
        Flux.fromStream(stream);

    }


}
