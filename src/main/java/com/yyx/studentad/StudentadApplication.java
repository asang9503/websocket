package com.yyx.studentad;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.yyx.studentad.mapper")
public class StudentadApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentadApplication.class, args);
    }

}
