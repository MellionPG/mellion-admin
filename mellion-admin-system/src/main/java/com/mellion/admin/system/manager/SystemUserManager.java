package com.mellion.admin.system.manager;

import com.mellion.admin.system.entity.TSystemMenu;

import java.util.List;

/**
 * 系统用户Manager接口
 *
 * @author MellionPG
 * @date 2023/3/6 20:50
 **/
public interface SystemUserManager {

    /**
     * 根据用户id获得菜单列表
     *
     * @param userId 用户id
     * @return 菜单列表
     */
    List<TSystemMenu> getSystemMenusByUserId(Long userId);

}
