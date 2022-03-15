package com.xuwei.springbootshiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuwei.springbootshiro.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description TODO
 * @Date 2022/2/28 10:56
 * @Author yxw
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
