package com.store.storeadmin.controller;

import com.store.storeadmin.pojo.Order;
import com.store.storeadmin.service.OrderService;
import com.store.storeadmin.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("")
    public Result findOrders(){
        List<Order> orders = orderService.findOrders();
        return Result.success(orders);
    }

    @GetMapping("delete_orders/{oid}")
    public Result deleteByOid(@PathVariable("oid")Integer oid){
        return orderService.deleteByOid(oid);
    }
}
