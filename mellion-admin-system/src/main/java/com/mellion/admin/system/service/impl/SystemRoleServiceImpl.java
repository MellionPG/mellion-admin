package com.mellion.admin.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.enums.BaseResponseStatus;
import com.mellion.admin.base.exception.ServiceException;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.system.entity.TSystemRole;
import com.mellion.admin.system.mapper.TSystemRoleMapper;
import com.mellion.admin.system.service.SystemRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 系统角色服务实现
 *
 * @author MellionPG
 * @date 2023/3/2 16:10
 **/
@Service
@RequiredArgsConstructor
public class SystemRoleServiceImpl implements SystemRoleService {

    /**
     * 系统角色Mapper
     */
    private final TSystemRoleMapper tSystemRoleMapper;

    @Override
    public TSystemRole getById(Long id) {
        return tSystemRoleMapper.selectById(id);
    }

    @Override
    public TSystemRole add(TSystemRole tSystemRole) {
        tSystemRole.setId(null);
        tSystemRoleMapper.insert(tSystemRole);
        return getById(tSystemRole.getId());
    }

    @Override
    public TSystemRole editById(TSystemRole tSystemRole) {
        Long id = tSystemRole.getId();
        if (Objects.isNull(id)) {
            throw new ServiceException(BaseResponseStatus.ID_IS_NULL);
        }
        if (Objects.isNull(tSystemRoleMapper.selectById(id))) {
            throw new ServiceException(BaseResponseStatus.DATA_IS_NULL);
        }
        tSystemRoleMapper.updateById(tSystemRole);
        return tSystemRoleMapper.selectById(id);
    }

    @Override
    public Boolean deleteById(Long id) {
        if (Objects.isNull(tSystemRoleMapper.selectById(id))) {
            throw new ServiceException(BaseResponseStatus.DATA_IS_NULL);
        }
        tSystemRoleMapper.deleteById(id);
        return true;
    }

    @Override
    public Page<TSystemRole> getPage(PageParam pageParam) {
        Page<TSystemRole> page = new Page<>(pageParam.getCurrentPage(), pageParam.getPageSize());
        return tSystemRoleMapper.selectPage(page, null);
    }

}
