package com.mellion.admin.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.enums.BaseResponseStatus;
import com.mellion.admin.base.exception.ServiceException;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.system.entity.TSystemDictItem;
import com.mellion.admin.system.mapper.TSystemDictItemMapper;
import com.mellion.admin.system.service.SystemDictItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 系统字典项服务实现
 *
 * @author MellionPG
 * @date 2023/2/28 12:08
 **/
@Service
@RequiredArgsConstructor
public class SystemDictItemServiceImpl implements SystemDictItemService {

    /**
     * 系统字典项Mapper
     */
    private final TSystemDictItemMapper tSystemDictItemMapper;

    @Override
    public TSystemDictItem getById(Long id) {
        return tSystemDictItemMapper.selectById(id);
    }

    @Override
    public TSystemDictItem add(TSystemDictItem tSystemDictItem) {
        tSystemDictItem.setId(null);
        tSystemDictItemMapper.insert(tSystemDictItem);
        return getById(tSystemDictItem.getId());
    }

    @Override
    public TSystemDictItem editById(TSystemDictItem tSystemDictItem) {
        Long id = tSystemDictItem.getId();
        if (Objects.isNull(id)) {
            throw new ServiceException(BaseResponseStatus.ID_IS_NULL);
        }
        if (Objects.isNull(tSystemDictItemMapper.selectById(id))) {
            throw new ServiceException(BaseResponseStatus.DATA_IS_NULL);
        }
        tSystemDictItemMapper.updateById(tSystemDictItem);
        return tSystemDictItemMapper.selectById(id);
    }

    @Override
    public Boolean deleteById(Long id) {
        if (Objects.isNull(tSystemDictItemMapper.selectById(id))) {
            throw new ServiceException(BaseResponseStatus.DATA_IS_NULL);
        }
        tSystemDictItemMapper.deleteById(id);
        return true;
    }

    @Override
    public Page<TSystemDictItem> getPage(PageParam pageParam) {
        Page<TSystemDictItem> page = new Page<>(pageParam.getCurrentPage(), pageParam.getPageSize());
        return tSystemDictItemMapper.selectPage(page, null);
    }

}
