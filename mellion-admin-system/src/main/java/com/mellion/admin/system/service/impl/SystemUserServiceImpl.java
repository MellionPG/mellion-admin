package com.mellion.admin.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.enums.BaseResponseStatus;
import com.mellion.admin.base.exception.ServiceException;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.system.entity.TSystemUser;
import com.mellion.admin.system.mapper.TSystemUserMapper;
import com.mellion.admin.system.service.SystemUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 系统用户服务实现
 *
 * @author MellionPG
 * @date 2023/3/2 16:13
 **/
@Service
@RequiredArgsConstructor
public class SystemUserServiceImpl implements SystemUserService {

    /**
     * 系统用户Mapper
     */
    private final TSystemUserMapper tSystemUserMapper;

    @Override
    public TSystemUser getById(Long id) {
        return tSystemUserMapper.selectById(id);
    }

    @Override
    public TSystemUser add(TSystemUser tSystemUser) {
        tSystemUser.setId(null);
        tSystemUserMapper.insert(tSystemUser);
        return getById(tSystemUser.getId());
    }

    @Override
    public TSystemUser editById(TSystemUser tSystemUser) {
        Long id = tSystemUser.getId();
        if (Objects.isNull(id)) {
            throw new ServiceException(BaseResponseStatus.ID_IS_NULL);
        }
        if (Objects.isNull(tSystemUserMapper.selectById(id))) {
            throw new ServiceException(BaseResponseStatus.DATA_IS_NULL);
        }
        tSystemUserMapper.updateById(tSystemUser);
        return tSystemUserMapper.selectById(id);
    }

    @Override
    public Boolean deleteById(Long id) {
        if (Objects.isNull(tSystemUserMapper.selectById(id))) {
            throw new ServiceException(BaseResponseStatus.DATA_IS_NULL);
        }
        tSystemUserMapper.deleteById(id);
        return true;
    }

    @Override
    public Page<TSystemUser> getPage(PageParam pageParam) {
        Page<TSystemUser> page = new Page<>(pageParam.getCurrentPage(), pageParam.getPageSize());
        return tSystemUserMapper.selectPage(page, null);
    }

}
