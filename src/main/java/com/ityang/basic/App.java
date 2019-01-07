package com.ityang.basic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ImportResource(locations = {"classpath:spring-bean.xml"})//,"classpath:spring-redis.xml"})
@MapperScan("com.ityang.basic.mapper")
public class App  {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    /**
     * 打包War包
     */
    public class SpringBootStartApplication extends SpringBootServletInitializer {
        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
            return builder.sources(App.class);
        }
    }

}
