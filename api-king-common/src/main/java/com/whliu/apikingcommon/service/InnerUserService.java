package com.whliu.apikingcommon.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.whliu.apikingcommon.model.entity.User;

/**
 * 用户服务
 *
 * @author whliu
 */
public interface InnerUserService {

    /**
     * 数据库中查是否已分配给用户密钥（accessKey）
     * @param accessKey
     * @return
     */
    User getInvokeUser(String accessKey);
}
