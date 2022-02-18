package com.xuwei.builder.case02;

/**
 * @Description 实体构建者类---苹果电脑构建者类
 * @Date 2022/2/8 11:00
 * @Author yxw
 */
public class MacComputerBuilder extends ComputerBuilder{
    private Computer computer;

    public MacComputerBuilder(String cpu, String ram) {
        computer = new Computer(cpu, ram);
    }

    @Override
    public void setUsbCount() {
        computer.setUsbCount(2);
    }

    @Override
    public void setKeyboard() {
        computer.setKeyboard("苹果键盘");
    }

    @Override
    public void setDisplay() {
        computer.setDisplay("苹果显示器");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
