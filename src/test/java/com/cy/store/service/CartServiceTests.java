package com.cy.store.service;

import com.cy.store.entity.Address;
import com.cy.store.vo.CartVO;
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
public class CartServiceTests {

    @Autowired
    private ICartService cartService;

    @Test
    public void addToCart(){
        cartService.addToCart(8,10000004,2,"小明");
    }

    @Test
    public void addNum(){
        cartService.addNum(2,8,"管理员");
    }

    @Test
    public void getVOByCid(){
        Integer[] cids = {1,2,5,6};
        List<CartVO> data = cartService.getVOByCid(8, cids);
        System.err.println(data);
    }
}
