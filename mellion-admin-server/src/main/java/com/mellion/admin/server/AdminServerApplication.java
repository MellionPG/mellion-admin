package com.mellion.admin.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 服务启动入口
 *
 * @author MellionPG
 * @date 2023/2/27 9:20
 **/
@SpringBootApplication(scanBasePackages = "com.mellion.admin")
public class AdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminServerApplication.class);
    }

}
