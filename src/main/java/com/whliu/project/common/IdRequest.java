package com.whliu.project.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 删除请求
 * 这样封装一下可以保持所有的POST接口格式保持统一
 *
 * @author whliu
 */
@Data
public class IdRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}