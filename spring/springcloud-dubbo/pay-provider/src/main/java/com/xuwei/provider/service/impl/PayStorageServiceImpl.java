package com.xuwei.provider.service.impl;

import com.xuwei.storage.service.StorageService;
import org.apache.dubbo.config.annotation.DubboService;

import java.io.InputStream;

/**
 * @Description TODO
 * @Date 2022/2/23 16:34
 * @Author yxw
 */
@DubboService(group = "payStorage", timeout = 3000)
public class PayStorageServiceImpl implements StorageService {
    @Override
    public InputStream getStorageStream() {
        System.out.println("使用自己定义的 storageservice 方法， pay-provider");
        return null;
    }
}
