package com.cy.store.controller;

import com.cy.store.entity.Order;
import com.cy.store.service.IOrderService;
import com.cy.store.util.JsonResult;
import com.cy.store.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("orders")
@RestController
public class OrderController extends BaseController{

    @Autowired
    private IOrderService orderService;

    @RequestMapping("create")
    public JsonResult<Order> create(Integer aid,
                                    HttpSession session,
                                    Integer[] cids){
        Order data = orderService.create(aid,
                getuidFromSession(session),
                getUsernameFromSession(session),
                cids);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("find_orders")
    public JsonResult<List<OrderVO>> findOrders(HttpSession session){
        List<OrderVO> data = orderService.findOrder(getuidFromSession(session));
        return new JsonResult<>(OK,data);
    }

}
