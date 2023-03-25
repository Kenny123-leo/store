package com.store.storeadmin.mapper;

import com.store.storeadmin.pojo.Order;

import java.util.List;

public interface OrderMapper {

    List<Order> findOrders();

    Integer deleteByOid(Integer oid);
}
