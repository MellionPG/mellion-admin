package com.mellion.admin.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.enums.BaseResponseStatus;
import com.mellion.admin.base.exception.ServiceException;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.system.entity.TSystemRoleMenu;
import com.mellion.admin.system.mapper.TSystemRoleMenuMapper;
import com.mellion.admin.system.service.SystemRoleMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 系统角色和菜单关联服务实现
 *
 * @author MellionPG
 * @date 2023/3/2 16:12
 **/
@Service
@RequiredArgsConstructor
public class SystemRoleMenuServiceImpl implements SystemRoleMenuService {

    /**
     * 系统角色和菜单关联Mapper
     */
    private final TSystemRoleMenuMapper tSystemRoleMenuMapper;

    @Override
    public TSystemRoleMenu getById(Long id) {
        return tSystemRoleMenuMapper.selectById(id);
    }

    @Override
    public TSystemRoleMenu add(TSystemRoleMenu tSystemRoleMenu) {
        tSystemRoleMenu.setId(null);
        tSystemRoleMenuMapper.insert(tSystemRoleMenu);
        return getById(tSystemRoleMenu.getId());
    }

    @Override
    public TSystemRoleMenu editById(TSystemRoleMenu tSystemRoleMenu) {
        Long id = tSystemRoleMenu.getId();
        if (Objects.isNull(id)) {
            throw new ServiceException(BaseResponseStatus.ID_IS_NULL);
        }
        if (Objects.isNull(tSystemRoleMenuMapper.selectById(id))) {
            throw new ServiceException(BaseResponseStatus.DATA_IS_NULL);
        }
        tSystemRoleMenuMapper.updateById(tSystemRoleMenu);
        return tSystemRoleMenuMapper.selectById(id);
    }

    @Override
    public Boolean deleteById(Long id) {
        if (Objects.isNull(tSystemRoleMenuMapper.selectById(id))) {
            throw new ServiceException(BaseResponseStatus.DATA_IS_NULL);
        }
        tSystemRoleMenuMapper.deleteById(id);
        return true;
    }

    @Override
    public Page<TSystemRoleMenu> getPage(PageParam pageParam) {
        Page<TSystemRoleMenu> page = new Page<>(pageParam.getCurrentPage(), pageParam.getPageSize());
        return tSystemRoleMenuMapper.selectPage(page, null);
    }

}
