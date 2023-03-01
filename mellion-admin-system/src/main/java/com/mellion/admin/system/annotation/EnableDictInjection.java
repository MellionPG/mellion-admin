package com.mellion.admin.system.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 该注解标注在控制器方法上，标识该方法开启字典注入
 * 同时支持标注在控制器类上，标识该类所有方法开启字典注入
 *
 * @author ifain
 * @date 2023/3/1 10:29
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableDictInjection {
}
