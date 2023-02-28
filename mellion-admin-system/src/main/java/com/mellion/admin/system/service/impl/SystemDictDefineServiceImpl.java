package com.mellion.admin.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.enums.BaseResponseStatus;
import com.mellion.admin.base.exception.ServiceException;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.system.entity.TSystemDictDefine;
import com.mellion.admin.system.mapper.TSystemDictDefineMapper;
import com.mellion.admin.system.service.SystemDictDefineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 系统字典定义服务实现
 *
 * @author MellionPG
 * @date 2023/2/28 11:31
 **/
@Service
@RequiredArgsConstructor
public class SystemDictDefineServiceImpl implements SystemDictDefineService {

    /**
     * 系统字典定义Mapper
     */
    private final TSystemDictDefineMapper tSystemDictDefineMapper;

    @Override
    public TSystemDictDefine getById(Long id) {
        return tSystemDictDefineMapper.selectById(id);
    }

    @Override
    public TSystemDictDefine add(TSystemDictDefine tSystemDictDefine) {
        tSystemDictDefine.setId(null);
        tSystemDictDefineMapper.insert(tSystemDictDefine);
        return getById(tSystemDictDefine.getId());
    }

    @Override
    public TSystemDictDefine editById(TSystemDictDefine tSystemDictDefine) {
        Long id = tSystemDictDefine.getId();
        if (Objects.isNull(id)) {
            throw new ServiceException(BaseResponseStatus.ID_IS_NULL);
        }
        if (Objects.isNull(tSystemDictDefineMapper.selectById(id))) {
            throw new ServiceException(BaseResponseStatus.DATA_IS_NULL);
        }
        tSystemDictDefineMapper.updateById(tSystemDictDefine);
        return tSystemDictDefineMapper.selectById(id);
    }

    @Override
    public Boolean deleteById(Long id) {
        if (Objects.isNull(tSystemDictDefineMapper.selectById(id))) {
            throw new ServiceException(BaseResponseStatus.DATA_IS_NULL);
        }
        tSystemDictDefineMapper.deleteById(id);
        return true;
    }

    @Override
    public Page<TSystemDictDefine> getPage(PageParam pageParam) {
        Page<TSystemDictDefine> page = new Page<>(pageParam.getCurrentPage(), pageParam.getPageSize());
        return tSystemDictDefineMapper.selectPage(page, null);
    }

}
