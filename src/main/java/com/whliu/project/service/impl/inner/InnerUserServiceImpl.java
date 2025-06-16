package com.whliu.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whliu.apikingcommon.model.entity.User;
import com.whliu.apikingcommon.service.InnerUserService;
import com.whliu.project.common.ErrorCode;
import com.whliu.project.exception.BusinessException;
import com.whliu.project.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserServiceImpl implements InnerUserService {

    // 在每个层中需要调用他下一层的方法，service层中调用mapper层的方法
    @Resource
    private UserMapper userMapper;

    /**
     * 实现接口中的getInvokeUser方法，用于根据密钥获取内部用户信息
     * @param accessKey
     * @return
     */
    @Override
    public User getInvokeUser(String accessKey) {
        if (StringUtils.isAnyBlank(accessKey)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accessKey", accessKey);
        return userMapper.selectOne(queryWrapper);
    }
}
