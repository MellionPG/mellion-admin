package com.mellion.admin.system.aspect;

import com.mellion.admin.base.pojo.ResponseResult;
import com.mellion.admin.system.service.SystemDictDefineService;
import com.mellion.admin.system.service.SystemDictItemService;
import com.mellion.admin.system.utils.DictDefineScanUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 数据字典数据注入切面
 *
 * @author MellionPG
 * @date 2023/2/28 15:04
 **/
@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class DictInjectAspect {

    /**
     * 字典定义服务
     */
    private final SystemDictDefineService systemDictDefineService;

    /**
     * 字典项服务
     */
    private final SystemDictItemService systemDictItemService;

    /**
     * 切入点方法
     */
    @Pointcut("execution(* com.mellion.admin..*.controller.*.*(..)) && (@annotation(com.mellion.admin.system.annotation.EnableDictInjection)" +
            "|| @target(com.mellion.admin.system.annotation.EnableDictInjection))")
    public void dictInject() {
    }

    @Around("dictInject()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long time1 = System.currentTimeMillis();
        Object result = pjp.proceed();
        long time2 = System.currentTimeMillis();
        log.info("控制器方法处理请求并输出结果，耗时：" + (time2 - time1) + "ms");

        long start = System.currentTimeMillis();
        this.injectDictText(result);
        long end = System.currentTimeMillis();
        log.info("完成数据字典类型字段的注入，耗时" + (end - start) + "ms");
        return result;
    }

    /**
     * 完成数据字典类型字段的注入
     *
     * @param result 响应结果
     */
    private void injectDictText(Object result) {
        // 判断响应结果是否为空或者是否为统一封装结果类ResponseResult
        if (Objects.isNull(result) || !(result instanceof ResponseResult)) {
            return;
        }
        ResponseResult<?> responseResult = (ResponseResult<?>) result;
        // 获取响应结果中的数据
        Object data = ((ResponseResult<?>) result).getData();
        // 获取data所有字段标注了@DictDefineProperty注解中的dictCode值
        Set<String> dictCodeSet = DictDefineScanUtil.scanObjectDictDefines(data);
        // 根据dictCode获取字典信息
        if (Objects.isNull(dictCodeSet) || dictCodeSet.isEmpty()) {
            return;
        }
        Map<String, Map<String, String>> dictDetail = new HashMap<>(dictCodeSet.size());
        for (String dictCode : dictCodeSet) {
            // 根据dictCode获取所有字段项，传入dictCode，返回一个Map<String, String>
            // 第一个String是value，第二个String是text
            Long defineId = systemDictDefineService.getDefineIdByCode(dictCode);
            Map<String, String> valueAndTextMap = systemDictItemService.getItemValueAndTextByDefineId(defineId);
            if (valueAndTextMap != null && !(valueAndTextMap.isEmpty())) {
                dictDetail.put(dictCode, valueAndTextMap);
            }
        }
        responseResult.setDict(dictDetail);
    }

}
