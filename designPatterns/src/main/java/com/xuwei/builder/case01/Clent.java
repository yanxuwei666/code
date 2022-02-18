package com.xuwei.builder.case01;

import java.sql.SQLOutput;

/**
 * @Description TODO
 * @Date 2022/2/8 10:38
 * @Author yxw
 */
public class Clent {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder("因特尔", "三星")
                .setDisplay("三星24寸")
                .setKeyboard("罗技")
                .setUsbCount(2)
                .build();
        System.out.println(computer);
    }
}
