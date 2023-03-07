package com.mellion.admin.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mellion.admin.system.entity.TSystemUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统角色Mapper
 *
 * @author MellionPG
 * @date 2023/3/2 15:42
 **/
@Mapper
public interface TSystemUserMapper extends BaseMapper<TSystemUser> {

    /**
     * 根据账号查询
     *
     * @param username 账号
     * @return 用户信息
     */
    default TSystemUser selectByUsername(String username) {
        return selectOne(new LambdaQueryWrapper<TSystemUser>().eq(TSystemUser::getUsername, username));
    }

}
