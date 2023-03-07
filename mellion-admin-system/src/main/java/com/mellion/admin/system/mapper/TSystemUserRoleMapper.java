package com.mellion.admin.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mellion.admin.system.entity.TSystemUserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统用户和角色关联Mapper
 *
 * @author MellionPG
 * @date 2023/3/2 15:43
 **/
@Mapper
public interface TSystemUserRoleMapper extends BaseMapper<TSystemUserRole> {

    /**
     * 根据用户id查询多个角色id
     *
     * @param userId 用户id
     * @return 角色id列表
     */
    List<Long> selectRoleIdsByUserId(Long userId);

}
