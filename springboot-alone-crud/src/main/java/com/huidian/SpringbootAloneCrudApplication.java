package com.huidian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


//@MapperScan("com.huidian.mapper")
@SpringBootApplication
@EnableCaching//开启缓存
public class SpringbootAloneCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAloneCrudApplication.class, args);
    }

}
