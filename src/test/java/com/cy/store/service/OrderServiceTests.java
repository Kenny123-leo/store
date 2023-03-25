package com.cy.store.service;

import com.cy.store.entity.Address;
import com.cy.store.entity.Order;
import com.cy.store.vo.OrderVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

// @SpringBootTest:表示标注当前的类是一个测试类，不会随同项目一块打包
@SpringBootTest
// @RunWith:表示启动这个单元测试类（单元测试类是不能够运行的），需要传递一个参数，必须是SpringRunner的实例类型
@RunWith(SpringRunner.class)
public class OrderServiceTests {

    @Autowired
    private IOrderService orderService;

    @Test
    public void create(){
        Integer[] cids = {3,4};
        Order order = orderService.create(10, 8, "张三", cids);
        System.out.println(order);
    }

    @Test
    public void findOrderByUidAndStatus(){
        List<OrderVO> order = orderService.findOrder(8);

        System.err.println(order);
    }


}
