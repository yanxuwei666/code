package com.xuwei.storage.service;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description TODO
 * @Date 2022/2/23 16:23
 * @Author yxw
 */
public class StorageServiceImpl implements StorageService {
    @Override
    public InputStream getStorageStream() {
        return new InputStream() {
            @Override
            public int read() throws IOException {
                System.out.println("hello world");
                return 0;
            }
        };
    }
}
