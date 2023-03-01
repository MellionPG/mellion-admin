package com.mellion.admin.system.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据字典注解，标识在类的字段（属性）上，说明该字段为数据字典类型（枚举类型）
 *
 * @author ifain
 * @date 2023/2/28 15:00
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DictDefineProperty {

    /**
     * 字典定义编码
     *
     * @return 字典定义编码
     */
    String dictCode();

}
