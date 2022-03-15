package com.xuwei.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Date 2022/2/22 15:30
 * @Author yxw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;

    private String name;

    private Long price;

    //库存
    private Long total;
}
