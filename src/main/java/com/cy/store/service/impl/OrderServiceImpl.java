package com.cy.store.service.impl;

import com.cy.store.entity.Address;
import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
import com.cy.store.mapper.OrderMapper;
import com.cy.store.service.IAddressService;
import com.cy.store.service.ICartService;
import com.cy.store.service.IOrderService;
import com.cy.store.service.ex.InsertException;
import com.cy.store.vo.CartVO;
import com.cy.store.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private ICartService cartService;

    @Override
    public Order create(Integer aid,
                        Integer uid,
                        String username,
                        Integer[] cids) {
        // 即将要下单的列表
        List<CartVO> list = cartService.getVOByCid(uid, cids);
        // 计算商品的总价
        Long totalPrice = 0L;
        for ( CartVO c:list) {
            totalPrice += c.getRealPrice() * c.getNum();
        }

        Address address = addressService.getByAid(aid, uid);

        Order order = new Order();
        order.setUid(uid);
        order.setRecvName(address.getName());
        order.setRecvPhone(address.getPhone());
        order.setRecvProvince(address.getProvinceName());
        order.setRecvCity(address.getCityName());
        order.setRecvArea(address.getAreaName());
        order.setRecvAddress(address.getAddress());
        // 支付、总价、时间
        order.setStatus(0);
        order.setTotalPrice(totalPrice);
        order.setOrderTime(new Date());
        // 日志
        order.setCreatedTime(new Date());
        order.setCreatedUser(username);
        order.setModifiedTime(new Date());
        order.setModifiedUser(username);
        // 插入数据
        Integer rows = orderMapper.insertOrder(order);
        if (rows != 1){
            throw new InsertException("插入数据异常");
        }
        // 创建订单详细项的数据
        for ( CartVO c:list) {
            // 创建一个订单项数据对象
            OrderItem orderItem = new OrderItem();
            orderItem.setOid(order.getOid());
            orderItem.setPid(c.getPid());
            orderItem.setTitle(c.getTitle());
            orderItem.setImage(c.getImage());
            orderItem.setPrice(c.getPrice());
            orderItem.setNum(c.getNum());
            // 日志字段
            orderItem.setCreatedTime(new Date());
            orderItem.setCreatedUser(username);
            orderItem.setModifiedTime(new Date());
            orderItem.setModifiedUser(username);

            rows = orderMapper.insertOrderItem(orderItem);
            if (rows != 1){
                throw new InsertException("插入数据异常");
            }
        }

        return order;
    }

    @Override
    public List<OrderVO> findOrder(Integer uid) {
        List<OrderVO> data = orderMapper.findOrderByUid(uid);
        for (int i = 0;i < data.toArray().length;i++){
            Integer status = data.get(i).getStatus();
            //根据status来判断是否已支付：0-未支付，1-已支付，2-已取消，3-已关闭，4-已完成
            if (status == 0){
                data.get(i).setStrstatus("未支付");
            }else if (status == 1){
                data.get(i).setStrstatus("已支付");
            }
            else if (status == 2){
                data.get(i).setStrstatus("已取消");
            }
            else if (status == 3){
                data.get(i).setStrstatus("已关闭");
            }
            else if (status == 4){
                data.get(i).setStrstatus("已完成");
            }
        }

        return data;
    }
}
