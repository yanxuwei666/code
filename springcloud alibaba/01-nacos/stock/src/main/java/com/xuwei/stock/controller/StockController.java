package com.xuwei.stock.controller;

/**
 * @Description TODO
 * @Date 2022/2/18 13:58
 * @Author yxw
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    @RequestMapping("/reduce")
    public String reduce(){
        System.out.println("扣减库存");
        return "reduce success";
    }
}
