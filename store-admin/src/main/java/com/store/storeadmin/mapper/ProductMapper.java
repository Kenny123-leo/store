package com.store.storeadmin.mapper;

import com.store.storeadmin.pojo.Product;

import java.util.List;

public interface ProductMapper {

    List<Product> findProducts();

    Integer deleteById(Integer id);
}
