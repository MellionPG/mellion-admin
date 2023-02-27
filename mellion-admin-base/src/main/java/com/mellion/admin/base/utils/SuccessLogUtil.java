package com.mellion.admin.base.utils;

import cn.hutool.extra.spring.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;

/**
 * 服务启动成功后输出日志工具
 *
 * @author MellionPG
 * @date 2023/2/27 14:32
 **/
@Slf4j
public class SuccessLogUtil {

    /**
     * 输出启动成功日志
     */
    public static void logSuccess() {
        Environment environment = SpringUtil.getBean(Environment.class);
        String port = environment.getProperty("server.port");
        String contextPath = environment.getProperty("server.servlet.context-path");
        contextPath = contextPath == null ? "" : contextPath;
        log.info("\n______                              _____ _             _           _ \n" +
                "| ___ \\                            /  ___| |           | |         | |\n" +
                "| |_/ / __ ___   ___ ___  ___ ___  \\ `--.| |_ __ _ _ __| |_ ___  __| |\n" +
                "|  __/ '__/ _ \\ / __/ _ \\/ __/ __|  `--. \\ __/ _` | '__| __/ _ \\/ _` |\n" +
                "| |  | | | (_) | (_|  __/\\__ \\__ \\ /\\__/ / || (_| | |  | ||  __/ (_| |\n" +
                "\\_|  |_|  \\___/ \\___\\___||___/___/ \\____/ \\__\\__,_|_|   \\__\\___|\\__,_|\n" +
                "                                                                      \n" +
                "                                                                      " +
                " \nknife4j接口文档地址：http://localhost:" + port + contextPath + "/doc.html");
    }

}
