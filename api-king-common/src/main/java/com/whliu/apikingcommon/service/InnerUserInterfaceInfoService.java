package com.whliu.apikingcommon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.whliu.apikingcommon.model.entity.UserInterfaceInfo;

/**
* @author king
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2025-06-09 17:16:32
*/
public interface InnerUserInterfaceInfoService {

    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);
}
