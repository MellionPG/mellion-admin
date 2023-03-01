package com.mellion.admin.system.utils;

import com.mellion.admin.system.annotation.DictDefineProperty;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 用于扫描类下的字段是否有标注@DictDefineProperty注解
 *
 * @author MellionPG
 * @date 2023/3/1 11:02
 **/
@Slf4j
public class DictDefineScanUtil {

    /**
     * 扫描object类里面所有字段是否有标注@DictDefineProperty注解
     *
     * @param object 被扫描的类
     * @return dictCode组成的set
     */
    public static Set<String> scanObjectDictDefines(Object object) {
        try {
            // 判断是否为空
            if (Objects.isNull(object)) {
                return null;
            }

            // 判断是否为基本数据类型
            Class<?> objectClass = object.getClass();
            if (objectClass.isPrimitive()) {
                return null;
            }

            // 判断是否为包装类或者字符串类型或者日期
            if (object instanceof Number || object instanceof String || object instanceof Boolean
                    || object instanceof Character || object instanceof LocalDateTime
                    || object instanceof LocalDate || object instanceof Date) {
                return null;
            }

            Set<String> resultSet = new HashSet<>();
            if (object instanceof List) {
                // 如果是List类型
                List<?> list = (List<?>) object;
                if (list.isEmpty()) {
                    return null;
                }
                Object firstItem = list.get(0);
                Set<String> subResultSet = scanObjectDictDefines(firstItem);
                if (subResultSet != null && !subResultSet.isEmpty()) {
                    resultSet.addAll(subResultSet);
                }
            } else if (objectClass.isArray()) {
                // 如果是数组
                Object[] array = (Object[]) object;
                if (array.length == 0) {
                    return null;
                }
                Object firstItem = array[0];
                Set<String> subResultSet = scanObjectDictDefines(firstItem);
                if (subResultSet != null && !subResultSet.isEmpty()) {
                    resultSet.addAll(subResultSet);
                }
            } else if (object instanceof Map) {
                // 如果是Map类型
                Map<?, ?> map = (Map<?, ?>) object;
                if (!map.isEmpty()) {
                    Map.Entry<?, ?> entry = map.entrySet().iterator().next();
                    // 获得第一个item的key
                    Object key = entry.getKey();
                    Set<String> subResultSet1 = scanObjectDictDefines(key);
                    if (subResultSet1 != null && !subResultSet1.isEmpty()) {
                        resultSet.addAll(subResultSet1);
                    }
                    // 获得第一个item的value
                    Object value = entry.getValue();
                    Set<String> subResultSet2 = scanObjectDictDefines(value);
                    if (subResultSet2 != null && !subResultSet2.isEmpty()) {
                        resultSet.addAll(subResultSet2);
                    }
                }
            } else {
                // 如果上述情况都不是，则开始遍历该object的所有属性
                List<Field> fieldList = new ArrayList<>();
                while (objectClass != null) {
                    fieldList.addAll(new ArrayList<>(Arrays.asList(objectClass.getDeclaredFields())));
                    objectClass = objectClass.getSuperclass();
                }
                for (Field field : fieldList) {
                    field.setAccessible(true);
                    Object fieldObject = field.get(object);
                    Set<String> subResultSet = scanObjectDictDefines(fieldObject);
                    if (subResultSet != null && !subResultSet.isEmpty()) {
                        resultSet.addAll(subResultSet);
                    }
                    if (field.isAnnotationPresent(DictDefineProperty.class)) {
                        DictDefineProperty fieldAnnotation = field.getAnnotation(DictDefineProperty.class);
                        String dictCode = fieldAnnotation.dictCode();
                        if (!dictCode.isEmpty()) {
                            resultSet.add(dictCode);
                        }
                    }
                }
            }
            return resultSet;
        } catch (Exception e) {
            log.error("扫描字典异常：{}", e.getMessage(), e);
            return null;
        }
    }

}
