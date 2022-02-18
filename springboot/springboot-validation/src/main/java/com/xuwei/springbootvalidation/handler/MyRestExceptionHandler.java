package com.xuwei.springbootvalidation.handler;

import com.xuwei.springbootcommon.com.xuwei.common.web.domain.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Date 2022/2/16 11:03
 * @Author yxw
 */
@Slf4j
@RestControllerAdvice
public class MyRestExceptionHandler {
    // 1.处理 form data方式调用接口校验失败抛出的异常
    @ExceptionHandler(value = BindException.class)
    public AjaxResult bindExceptionHandler(BindException e) {
        log.error("form data方式调用接口校验失信息 ex={}", e.getMessage(), e);
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> collect = fieldErrors.stream().map(o -> o.getDefaultMessage()).collect(Collectors.toList());

        return AjaxResult.error(e.getMessage(), collect);
    }

    // 2.处理 json 请求体调用接口校验失败抛出的异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public AjaxResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> collect = fieldErrors.stream().map(o -> o.getDefaultMessage()).collect(Collectors.toList());
        return AjaxResult.error(e.getMessage(), collect);
    }

    // 3.处理单个参数校验失败抛出的异常
    @ExceptionHandler(ConstraintViolationException.class)
    public AjaxResult constraintViolationExceptionHandler(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        List<String> collect = constraintViolations.stream()
                .map(o -> o.getMessage())
                .collect(Collectors.toList());
        return AjaxResult.error(e.getMessage(), collect);
    }
}
