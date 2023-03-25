package com.cy.store.controller;

import com.cy.store.entity.Product;
import com.cy.store.service.IProductService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController extends BaseController{

    @Autowired
    private IProductService productService;

    @RequestMapping("get_hotlist")
    public JsonResult<List<Product>> findHotList(){
        List<Product> data = productService.findHotList();
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("details/{id}")
    public JsonResult<Product> getProductDetail(@PathVariable("id") Integer id){
        Product data = productService.findProductByid(id);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("get_newlist")
    public JsonResult<List<Product>> findNewList(){
        List<Product> data = productService.findNewList();
        return new JsonResult<>(OK,data);
    }
}
