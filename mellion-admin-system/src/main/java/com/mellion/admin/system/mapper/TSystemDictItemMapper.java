package com.mellion.admin.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mellion.admin.system.entity.TSystemDictItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 系统字典项Mapper
 *
 * @author MellionPG
 * @date 2023/2/28 11:59
 **/
@Mapper
public interface TSystemDictItemMapper extends BaseMapper<TSystemDictItem> {

    /**
     * 根据字典定义ID查所有字典项的value和text
     *
     * @param defineId 字典定义ID
     * @return 由字典项value和text组成的map
     */
    List<Map<String, String>> getItemValueAndTextByDefineId(Long defineId);

}
