package com.xuwei.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuwei.security.domain.SysRequestPath;
import org.apache.ibatis.annotations.Mapper;

/**
* @author yxw
* @description 针对表【sys_request_path(请求路径)】的数据库操作Mapper
* @createDate 2022-03-07 09:39:31
* @Entity com.xuwei.security.domain.SysRequestPath
*/
@Mapper
public interface SysRequestPathMapper extends BaseMapper<SysRequestPath> {


}
