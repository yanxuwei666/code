package com.xuwei.builder.case02;

/**
 * @Description 抽象构建者类
 * @Date 2022/2/8 10:59
 * @Author yxw
 */
public abstract class ComputerBuilder {
    public abstract void setUsbCount();
    public abstract void setKeyboard();
    public abstract void setDisplay();

    public abstract Computer getComputer();
}
