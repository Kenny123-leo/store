package com.store.storeadmin.serviceTests;

import com.store.storeadmin.pojo.Order;
import com.store.storeadmin.service.OrderService;
import com.store.storeadmin.vo.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
// @RunWith:表示启动这个单元测试类（单元测试类是不能够运行的），需要传递一个参数，必须是SpringRunner的实例类型
@RunWith(SpringRunner.class)
public class OrderServiceTests {

    @Autowired
    private OrderService orderService;

    @Test
    public void order(){
        List<Order> orders = orderService.findOrders();
        System.err.println(orders);

    }
}
