package com.mellion.admin.server;

import com.mellion.admin.system.service.SystemDictDefineService;
import com.mellion.admin.system.service.SystemDictItemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * 测试字典服务
 *
 * @author MellionPG
 * @date 2023/3/1 12:18
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AdminServerApplication.class})
@EnableAutoConfiguration
@Slf4j
public class DictServiceTest {

    @Autowired
    private SystemDictDefineService systemDictDefineService;

    @Autowired
    private SystemDictItemService systemDictItemService;

    @Test
    public void testDiceService() {
        Long sexDefineId = systemDictDefineService.getDefineIdByCode("sex");
        log.info("字典定义测试：{}", sexDefineId);
        Map<String, String> result = systemDictItemService.getItemValueAndTextByDefineId(sexDefineId);
        log.info("字典项测试：{}", result);
    }

}
