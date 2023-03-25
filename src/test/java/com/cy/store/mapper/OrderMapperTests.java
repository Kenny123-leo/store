package com.cy.store.mapper;

import com.cy.store.entity.Cart;
import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
import com.cy.store.vo.OrderVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

// @SpringBootTest:表示标注当前的类是一个测试类，不会随同项目一块打包
@SpringBootTest
// @RunWith:表示启动这个单元测试类（单元测试类是不能够运行的），需要传递一个参数，必须是SpringRunner的实例类型
@RunWith(SpringRunner.class)
public class OrderMapperTests {

    @Autowired
    private  OrderMapper orderMapper;

    @Test
    public void insetOrder(){
        Order order = new Order();
        order.setUid(8);
        order.setRecvName("明明");
        order.setRecvPhone("1231314");

        orderMapper.insertOrder(order);
    }

    @Test
    public void insetOrderItem(){
        OrderItem order = new OrderItem();
        order.setOid(1);
        order.setPid(10000003);
        order.setTitle("广博(GuangBo)10本装40张A5牛皮纸记事本子日记本办公软抄本GBR0731");

        orderMapper.insertOrderItem(order);
    }

    @Test
    public void findOrderByUid(){
        List<OrderVO> list = orderMapper.findOrderByUid(8);
        for (OrderVO vo : list) {
            System.err.println(vo);
        }
    }

}
