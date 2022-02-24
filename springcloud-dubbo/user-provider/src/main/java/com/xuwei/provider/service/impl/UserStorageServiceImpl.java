package com.xuwei.provider.service.impl;

import com.xuwei.common.service.UserService;
import com.xuwei.storage.service.StorageService;
import org.apache.dubbo.config.annotation.DubboService;

import java.io.InputStream;

/**
 * @Description TODO
 * @Date 2022/2/24 8:45
 * @Author yxw
 */
@DubboService(group = "userStorage")
public class UserStorageServiceImpl implements StorageService {
    @Override
    public InputStream getStorageStream() {
        System.out.println("使用自己定义的 storageservice 方法， user-provider");
        return null;
    }
}
