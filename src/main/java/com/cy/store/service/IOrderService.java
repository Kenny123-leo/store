package com.cy.store.service;

import com.cy.store.entity.Order;
import com.cy.store.vo.OrderVO;

import java.util.List;

public interface IOrderService {

    Order create(Integer aid,
                 Integer uid,
                 String username,
                 Integer[] cids);

    List<OrderVO> findOrder(Integer uid);
}
