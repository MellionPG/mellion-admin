package com.mellion.admin.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mellion.admin.system.entity.TSystemDictDefine;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统字典定义Mapper
 *
 * @author MellionPG
 * @date 2023/2/28 11:25
 **/
@Mapper
public interface TSystemDictDefineMapper extends BaseMapper<TSystemDictDefine> {

    /**
     * 根据编码获取id
     *
     * @param code 字典编码
     * @return 字典定义ID
     */
    Long getDefineIdByCode(String code);

}
