package com.store.storeadmin.controller;

import com.store.storeadmin.pojo.Product;
import com.store.storeadmin.service.ProductService;
import com.store.storeadmin.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("")
    public Result findProducts(){
        List<Product> list = productService.findProducts();
        return Result.success(list);
    }

    @GetMapping("delete_product/{id}")
    public Result deleteByid(@PathVariable("id")Integer id){
        return productService.deleteByid(id);
    }
}
