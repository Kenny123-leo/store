package com.cy.store.service.impl;

import com.cy.store.entity.Product;
import com.cy.store.mapper.ProductMapper;
import com.cy.store.service.IProductService;
import com.cy.store.service.ex.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** 处理商品数据业务层的实现类*/
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findHotList() {
        List<Product> list = productMapper.findHotList();
        return list;
    }

    @Override
    public Product findProductByid(Integer id) {
        Product product = productMapper.findProductById(id);
        if (product == null){
            throw new ProductNotFoundException("商品没有被发现");
        }
        return product;
    }

    @Override
    public List<Product> findNewList() {
        List<Product> newList = productMapper.findNewList();
        return newList;
    }
}
