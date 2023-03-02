package com.mellion.admin.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.enums.BaseResponseStatus;
import com.mellion.admin.base.exception.ServiceException;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.system.entity.TSystemMenu;
import com.mellion.admin.system.mapper.TSystemMenuMapper;
import com.mellion.admin.system.service.SystemMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 系统菜单服务实现
 *
 * @author MellionPG
 * @date 2023/3/2 16:08
 **/
@Service
@RequiredArgsConstructor
public class SystemMenuServiceImpl implements SystemMenuService {

    /**
     * 系统菜单Mapper
     */
    private final TSystemMenuMapper tSystemMenuMapper;

    @Override
    public TSystemMenu getById(Long id) {
        return tSystemMenuMapper.selectById(id);
    }

    @Override
    public TSystemMenu add(TSystemMenu tSystemMenu) {
        tSystemMenu.setId(null);
        tSystemMenuMapper.insert(tSystemMenu);
        return getById(tSystemMenu.getId());
    }

    @Override
    public TSystemMenu editById(TSystemMenu tSystemMenu) {
        Long id = tSystemMenu.getId();
        if (Objects.isNull(id)) {
            throw new ServiceException(BaseResponseStatus.ID_IS_NULL);
        }
        if (Objects.isNull(tSystemMenuMapper.selectById(id))) {
            throw new ServiceException(BaseResponseStatus.DATA_IS_NULL);
        }
        tSystemMenuMapper.updateById(tSystemMenu);
        return tSystemMenuMapper.selectById(id);
    }

    @Override
    public Boolean deleteById(Long id) {
        if (Objects.isNull(tSystemMenuMapper.selectById(id))) {
            throw new ServiceException(BaseResponseStatus.DATA_IS_NULL);
        }
        tSystemMenuMapper.deleteById(id);
        return true;
    }

    @Override
    public Page<TSystemMenu> getPage(PageParam pageParam) {
        Page<TSystemMenu> page = new Page<>(pageParam.getCurrentPage(), pageParam.getPageSize());
        return tSystemMenuMapper.selectPage(page, null);
    }

}
