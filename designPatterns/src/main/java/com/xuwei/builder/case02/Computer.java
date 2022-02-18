package com.xuwei.builder.case02;

import lombok.Data;

/**
 * @Description 电脑类，2个必要参数3个可选参数
 * @Date 2022/2/8 10:35
 * @Author yxw
 */
@Data
public class Computer {
    private String cpu;//必须
    private String ram;//必须
    private int usbCount;//可选
    private String keyboard;//可选
    private String display;//可选

    public Computer(String cpu, String ram) {
        this.cpu = cpu;
        this.ram = ram;
    }
}
