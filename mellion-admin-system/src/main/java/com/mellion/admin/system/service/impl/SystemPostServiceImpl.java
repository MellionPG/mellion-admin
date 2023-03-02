package com.mellion.admin.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.enums.BaseResponseStatus;
import com.mellion.admin.base.exception.ServiceException;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.system.entity.TSystemPost;
import com.mellion.admin.system.mapper.TSystemPostMapper;
import com.mellion.admin.system.service.SystemPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 系统岗位服务实现
 *
 * @author MellionPG
 * @date 2023/3/2 16:09
 **/
@Service
@RequiredArgsConstructor
public class SystemPostServiceImpl implements SystemPostService {

    /**
     * 系统岗位Mapper
     */
    private final TSystemPostMapper tSystemPostMapper;

    @Override
    public TSystemPost getById(Long id) {
        return tSystemPostMapper.selectById(id);
    }

    @Override
    public TSystemPost add(TSystemPost tSystemPost) {
        tSystemPost.setId(null);
        tSystemPostMapper.insert(tSystemPost);
        return getById(tSystemPost.getId());
    }

    @Override
    public TSystemPost editById(TSystemPost tSystemPost) {
        Long id = tSystemPost.getId();
        if (Objects.isNull(id)) {
            throw new ServiceException(BaseResponseStatus.ID_IS_NULL);
        }
        if (Objects.isNull(tSystemPostMapper.selectById(id))) {
            throw new ServiceException(BaseResponseStatus.DATA_IS_NULL);
        }
        tSystemPostMapper.updateById(tSystemPost);
        return tSystemPostMapper.selectById(id);
    }

    @Override
    public Boolean deleteById(Long id) {
        if (Objects.isNull(tSystemPostMapper.selectById(id))) {
            throw new ServiceException(BaseResponseStatus.DATA_IS_NULL);
        }
        tSystemPostMapper.deleteById(id);
        return true;
    }

    @Override
    public Page<TSystemPost> getPage(PageParam pageParam) {
        Page<TSystemPost> page = new Page<>(pageParam.getCurrentPage(), pageParam.getPageSize());
        return tSystemPostMapper.selectPage(page, null);
    }

}
