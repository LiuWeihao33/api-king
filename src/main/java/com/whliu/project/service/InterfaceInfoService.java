package com.whliu.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.whliu.apikingcommon.model.entity.InterfaceInfo;

/**
* @author king
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2025-06-05 10:45:26
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
