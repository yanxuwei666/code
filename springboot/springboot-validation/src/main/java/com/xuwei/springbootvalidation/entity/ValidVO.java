package com.xuwei.springbootvalidation.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @Description TODO
 * @Date 2022/2/16 10:39
 * @Author yxw
 */
@Data
public class ValidVO {
    @Length(min  = 6,max = 12,message = "appId 长度必须位于 6 到 12 之间")
    private String appId;

    @NotBlank(message  = "名字为必填项")
    private String name;

    @Email(message  = "请填写正确的邮箱地址")
    private String email;

    private String sex;

    @NotEmpty(message  = "级别不能为空")
    private String level;
}
