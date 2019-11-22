package com.huidian;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ConfigDataSource {

    @ConfigurationProperties(prefix = "spring.datasource")  //将此数据注入到bean对象
    @Bean      //初始化Spring容器,构建对应的bean对象
    public DataSource druid(){
        return new DruidDataSource();
    }
}
