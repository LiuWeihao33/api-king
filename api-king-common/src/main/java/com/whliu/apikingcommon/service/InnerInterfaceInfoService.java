package com.whliu.apikingcommon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.whliu.apikingcommon.model.entity.InterfaceInfo;

/**
* @author king
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2025-06-05 10:45:26
*/
public interface InnerInterfaceInfoService {

    /**
     * 数据库中查询模拟接口是否存在（请求路径、请求方法、请求参数）
     * @param path
     * @param method
     * @return
     */
    InterfaceInfo getInterfaceInfo(String path, String method);
}
