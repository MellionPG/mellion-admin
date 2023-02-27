package com.mellion.admin.server.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mellion.admin.server.test.entity.TTestDemo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 测试样例Mapper
 *
 * @author MellionPG
 * @date 2023/2/27 10:48
 **/
@Mapper
public interface TTestDemoMapper extends BaseMapper<TTestDemo> {
}
