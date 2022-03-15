package com.xuwei.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description TODO
 * @Date 2022/2/22 15:29
 * @Author yxw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private Long id;

    //总金额
    private Long useMoney;

    public Order(Long id, Long useMoney) {
        this.id = id;
        this.useMoney = useMoney;
    }

    private String userId;

    private List<Product> products;
}
