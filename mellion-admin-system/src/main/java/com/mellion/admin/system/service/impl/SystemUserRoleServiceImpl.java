package com.mellion.admin.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.enums.BaseResponseStatus;
import com.mellion.admin.base.exception.ServiceException;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.system.entity.TSystemUserRole;
import com.mellion.admin.system.mapper.TSystemUserRoleMapper;
import com.mellion.admin.system.service.SystemUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 系统用户和角色关联服务实现
 *
 * @author MellionPG
 * @date 2023/3/2 16:14
 **/
@Service
@RequiredArgsConstructor
public class SystemUserRoleServiceImpl implements SystemUserRoleService {

    /**
     * 系统用户和角色关联Mapper
     */
    private final TSystemUserRoleMapper tSystemUserRoleMapper;

    @Override
    public TSystemUserRole getById(Long id) {
        return tSystemUserRoleMapper.selectById(id);
    }

    @Override
    public TSystemUserRole add(TSystemUserRole tSystemUserRole) {
        tSystemUserRole.setId(null);
        tSystemUserRoleMapper.insert(tSystemUserRole);
        return getById(tSystemUserRole.getId());
    }

    @Override
    public TSystemUserRole editById(TSystemUserRole tSystemUserRole) {
        Long id = tSystemUserRole.getId();
        if (Objects.isNull(id)) {
            throw new ServiceException(BaseResponseStatus.ID_IS_NULL);
        }
        if (Objects.isNull(tSystemUserRoleMapper.selectById(id))) {
            throw new ServiceException(BaseResponseStatus.DATA_IS_NULL);
        }
        tSystemUserRoleMapper.updateById(tSystemUserRole);
        return tSystemUserRoleMapper.selectById(id);
    }

    @Override
    public Boolean deleteById(Long id) {
        if (Objects.isNull(tSystemUserRoleMapper.selectById(id))) {
            throw new ServiceException(BaseResponseStatus.DATA_IS_NULL);
        }
        tSystemUserRoleMapper.deleteById(id);
        return true;
    }

    @Override
    public Page<TSystemUserRole> getPage(PageParam pageParam) {
        Page<TSystemUserRole> page = new Page<>(pageParam.getCurrentPage(), pageParam.getPageSize());
        return tSystemUserRoleMapper.selectPage(page, null);
    }

}
