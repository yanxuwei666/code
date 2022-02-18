package com.xuwei.builder.case02;

/**
 * @Description 指导者类
 * @Date 2022/2/8 11:02
 * @Author yxw
 */
public class ComputerDirector {
    public void makeComputer(ComputerBuilder builder){
        builder.setUsbCount();
        builder.setDisplay();
        builder.setKeyboard();
    }
}
