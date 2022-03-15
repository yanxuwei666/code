package com.xuwei.springbootshiro.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Description TODO
 * @Date 2022/2/28 9:49
 * @Author yxw
 */
@TableName("t_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String username;
    private String password;
    private String salt;
}
