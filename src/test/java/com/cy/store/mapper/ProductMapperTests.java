package com.cy.store.mapper;

import com.cy.store.entity.Address;
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
public class ProductMapperTests {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void findHotList(){
        List<Product> list = productMapper.findHotList();
        System.err.println(list);
    }



}
