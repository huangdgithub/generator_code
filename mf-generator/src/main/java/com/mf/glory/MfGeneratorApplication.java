package com.mf.glory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.mf.glory"})
@MapperScan(basePackages = {"com.mf.glory.mapper"})
@EnableAutoConfiguration
public class MfGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MfGeneratorApplication.class, args);
    }

}
