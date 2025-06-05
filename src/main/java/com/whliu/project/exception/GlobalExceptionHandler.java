package com.whliu.project.exception;

import com.whliu.project.common.BaseResponse;
import com.whliu.project.common.ErrorCode;
import com.whliu.project.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author whliu
 */

/**
 * 这是一个组合注解，相当于 @ControllerAdvice + @ResponseBody。
 *
 * @ControllerAdvice：标识该类为全局异常处理器，可以捕获整个应用中控制器（Controller）抛出的异常。
 * @ResponseBody：将方法的返回值自动序列化为 JSON 格式响应给客户端。
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 指定该方法处理 BusinessException 类型的异常。当控制器中抛出 BusinessException 时，会调用此方法。
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public BaseResponse<?> businessExceptionHandler(BusinessException e) {
        log.error("businessException: " + e.getMessage(), e);
        return ResultUtils.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse<?> runtimeExceptionHandler(RuntimeException e) {
        log.error("runtimeException", e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, e.getMessage());
    }
}
