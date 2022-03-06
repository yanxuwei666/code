package com.xuwei.test;

import com.xuwei.core.constant.HttpStatus;
import com.xuwei.core.domain.AjaxResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Date 2022/3/4 16:49
 * @Author yxw
 */
public class TestAjaxResult {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("username", "admin");
        map.put("password", "123456");
        System.out.println(AjaxResult.success());
        System.out.println(AjaxResult.success("成功"));
        System.out.println(AjaxResult.success(map));
        System.out.println(AjaxResult.success("成功", map));

        System.out.println(AjaxResult.error());
        System.out.println(AjaxResult.error("失败"));
        System.out.println(AjaxResult.error(map));
        System.out.println(AjaxResult.error("失败", map));

        System.out.println(AjaxResult.error(HttpStatus.UNAUTHORIZED, "无授权，请联系管理员"));
    }
}
