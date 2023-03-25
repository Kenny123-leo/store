package com.store.storeadmin.service;

import com.store.storeadmin.mapper.ProductMapper;
import com.store.storeadmin.pojo.Product;
import com.store.storeadmin.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public List<Product> findProducts(){
        List<Product> list = productMapper.findProducts();
        return list;
    }

    public Result deleteByid(Integer id){
        Integer integer = productMapper.deleteById(id);
        if (integer < 1) {
            return Result.fail(4004,"删除出错了");
        }
        return Result.success(null);
    }
}
