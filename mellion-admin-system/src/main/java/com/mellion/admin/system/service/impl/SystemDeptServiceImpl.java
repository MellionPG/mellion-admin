package com.mellion.admin.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.enums.BaseResponseStatus;
import com.mellion.admin.base.exception.ServiceException;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.system.entity.TSystemDept;
import com.mellion.admin.system.mapper.TSystemDeptMapper;
import com.mellion.admin.system.service.SystemDeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 系统部门服务实现
 *
 * @author MellionPG
 * @date 2023/3/2 16:06
 **/
@Service
@RequiredArgsConstructor
public class SystemDeptServiceImpl implements SystemDeptService {

    /**
     * 系统部门Mapper
     */
    private final TSystemDeptMapper tSystemDeptMapper;

    @Override
    public TSystemDept getById(Long id) {
        return tSystemDeptMapper.selectById(id);
    }

    @Override
    public TSystemDept add(TSystemDept tSystemDept) {
        tSystemDept.setId(null);
        tSystemDeptMapper.insert(tSystemDept);
        return getById(tSystemDept.getId());
    }

    @Override
    public TSystemDept editById(TSystemDept tSystemDept) {
        Long id = tSystemDept.getId();
        if (Objects.isNull(id)) {
            throw new ServiceException(BaseResponseStatus.ID_IS_NULL);
        }
        if (Objects.isNull(tSystemDeptMapper.selectById(id))) {
            throw new ServiceException(BaseResponseStatus.DATA_IS_NULL);
        }
        tSystemDeptMapper.updateById(tSystemDept);
        return tSystemDeptMapper.selectById(id);
    }

    @Override
    public Boolean deleteById(Long id) {
        if (Objects.isNull(tSystemDeptMapper.selectById(id))) {
            throw new ServiceException(BaseResponseStatus.DATA_IS_NULL);
        }
        tSystemDeptMapper.deleteById(id);
        return true;
    }

    @Override
    public Page<TSystemDept> getPage(PageParam pageParam) {
        Page<TSystemDept> page = new Page<>(pageParam.getCurrentPage(), pageParam.getPageSize());
        return tSystemDeptMapper.selectPage(page, null);
    }

}
