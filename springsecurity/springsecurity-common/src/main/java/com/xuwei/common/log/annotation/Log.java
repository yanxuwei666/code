package com.xuwei.common.log.annotation;

import com.xuwei.common.log.enums.BusinessType;
import com.xuwei.common.log.enums.OperatorType;

import java.lang.annotation.*;

/**
 * @Description 自定义操作日志
 * @Date 2022/2/15 16:55
 * @Author yxw
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log
{
    /**
     * 模块
     */
    public String title() default "";

    /**
     * 功能
     */
    public BusinessType businessType() default BusinessType.OTHER;

    /**
     * 操作人类别
     */
    public OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    public boolean isSaveRequestData() default true;

    /**
     * 是否保存响应的参数
     */
    public boolean isSaveResponseData() default true;
}
