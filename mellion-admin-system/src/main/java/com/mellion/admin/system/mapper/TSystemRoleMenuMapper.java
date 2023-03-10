package com.mellion.admin.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mellion.admin.system.entity.TSystemRoleMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统角色和菜单关联Mapper
 *
 * @author MellionPG
 * @date 2023/3/2 15:43
 **/
@Mapper
public interface TSystemRoleMenuMapper extends BaseMapper<TSystemRoleMenu> {

    /**
     * 根据角色id查询菜单ids
     *
     * @param roleId 角色id
     * @return 菜单id列表
     */
    List<Long> selectMenuIdsByRoleId(Long roleId);

}
