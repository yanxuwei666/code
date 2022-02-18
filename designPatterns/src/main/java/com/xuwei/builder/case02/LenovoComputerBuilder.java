package com.xuwei.builder.case02;

/**
 * @Description 实体构建者类---联想电脑构建者类
 * @Date 2022/2/8 11:00
 * @Author yxw
 */
public class LenovoComputerBuilder extends ComputerBuilder{
    private Computer computer;

    public LenovoComputerBuilder(String cpu, String ram) {
        computer = new Computer(cpu, ram);
    }

    @Override
    public void setUsbCount() {
        computer.setUsbCount(2);
    }

    @Override
    public void setKeyboard() {
        computer.setKeyboard("联想键盘");
    }

    @Override
    public void setDisplay() {
        computer.setDisplay("联想显示器");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
