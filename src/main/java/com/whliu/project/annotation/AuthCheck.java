package com.whliu.project.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 权限校验
 *
 * @author whliu
 */
@Target(ElementType.METHOD) // 指定注解可以应用在哪些元素上（这里指定方法）
@Retention(RetentionPolicy.RUNTIME) // 指定注解在什么阶段保留（这里指定运行时保留）
public @interface AuthCheck {

    /**
     * 有任何一个角色
     *
     * @return
     */
    String[] anyRole() default ""; // 可选描述信息，默认值是空字符串

    /**
     * 必须有某个角色
     *
     * @return
     */
    String mustRole() default ""; // 可选描述信息

}

