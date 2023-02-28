package com.mellion.admin.server;

import com.mellion.admin.base.utils.SuccessLogUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 服务启动入口
 *
 * @author MellionPG
 * @date 2023/2/27 9:20
 **/
@SpringBootApplication(scanBasePackages = "com.mellion.admin")
@MapperScan(basePackages = "com.mellion.admin.**.mapper")
public class AdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminServerApplication.class);
        SuccessLogUtil.logSuccess();
    }

}
