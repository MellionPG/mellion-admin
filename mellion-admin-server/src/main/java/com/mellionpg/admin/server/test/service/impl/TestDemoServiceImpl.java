package com.mellionpg.admin.server.test.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellionpg.admin.base.enums.BaseResponseStatus;
import com.mellionpg.admin.base.exception.ServiceException;
import com.mellionpg.admin.base.pojo.PageParam;
import com.mellionpg.admin.server.test.entity.TTestDemo;
import com.mellionpg.admin.server.test.mapper.TTestDemoMapper;
import com.mellionpg.admin.server.test.service.TestDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 测试样例服务实现
 *
 * @author MellionPG
 * @date 2023/2/27 10:49
 **/
@Service
@RequiredArgsConstructor
public class TestDemoServiceImpl implements TestDemoService {

    /**
     * 测试样例Mapper
     */
    private final TTestDemoMapper tTestDemoMapper;

    @Override
    public TTestDemo getById(Long id) {
        return tTestDemoMapper.selectById(id);
    }

    @Override
    public TTestDemo add(TTestDemo tTestDemo) {
        tTestDemo.setId(null);
        tTestDemoMapper.insert(tTestDemo);
        return tTestDemo;
    }

    @Override
    public TTestDemo editById(TTestDemo tTestDemo) {
        Long id = tTestDemo.getId();
        if (Objects.isNull(id)) {
            throw new ServiceException(BaseResponseStatus.ID_IS_NULL);
        }
        if (Objects.isNull(tTestDemoMapper.selectById(id))) {
            throw new ServiceException(BaseResponseStatus.DATA_IS_NULL);
        }
        tTestDemoMapper.updateById(tTestDemo);
        return tTestDemoMapper.selectById(id);
    }

    @Override
    public Boolean deleteById(Long id) {
        if (Objects.isNull(tTestDemoMapper.selectById(id))) {
            throw new ServiceException(BaseResponseStatus.DATA_IS_NULL);
        }
        tTestDemoMapper.deleteById(id);
        return true;
    }

    @Override
    public Page<TTestDemo> getPage(PageParam pageParam) {
        Page<TTestDemo> page = new Page<>(pageParam.getCurrentPage(), pageParam.getPageSize());
        return tTestDemoMapper.selectPage(page, null);
    }

}
