package com.xuwei.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuwei.security.domain.SysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author yxw
* @description 针对表【sys_permission(权限表)】的数据库操作Mapper
* @createDate 2022-03-07 09:39:31
* @Entity com.xuwei.security.domain.SysPermission
*/
@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    /**
     * 查询用户的权限列表
     *
     * @param userId
     * @return
     */
    List<SysPermission> selectListByUser(Integer userId);

    /**
     * 查询具体某个接口的权限
     *
     * @param path 接口路径
     * @return
     */
    List<SysPermission> selectListByPath(String path);

}
