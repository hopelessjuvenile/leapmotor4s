package com.leapmotor4s;

import com.leapmotor4s.system.config.MinioConfiguration;
import com.leapmotor4s.system.config.MinioProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan({"com.leapmotor4s.system.mapper"})
public class Leapmotor4sApplication {

    public static void main(String[] args) {
        SpringApplication.run(Leapmotor4sApplication.class, args);
    }

    @GetMapping("/")
    public String index(){
        return "ok";
    }
}
