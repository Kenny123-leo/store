package com.cy.store.mapper;

import com.cy.store.entity.Cart;
import com.cy.store.entity.Product;
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
public class CartMapperTests {

    @Autowired
    private  CartMapper cartMapper;

    @Test
    public void insert(){
        Cart cart = new Cart();
        cart.setUid(8);
        cart.setNum(1);
        cart.setPid(10000004);
        cart.setPrice(1000L);
        cartMapper.insert(cart);
    }

    @Test
    public void updateNumByCid(){
        cartMapper.updateNumByCid(1,3,"test002",new Date());
    }

    @Test
    public void findByUidAndPid(){
        System.err.println(cartMapper.findByUidAndPid(8, 10000004));
    }

    @Test
    public void findVOByUid(){
        System.err.println(cartMapper.findVOByUid(8));
    }

    @Test
    public void findBycid(){
        System.err.println(cartMapper.findByCid(2));
    }

    @Test
    public void findVOByCid(){
        Integer[] cids = {1,2,5,6};
        System.err.println(cartMapper.findVOByCid(cids));
    }

}
