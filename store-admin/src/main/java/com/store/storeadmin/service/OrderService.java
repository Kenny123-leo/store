package com.store.storeadmin.service;

import com.store.storeadmin.mapper.OrderMapper;
import com.store.storeadmin.pojo.Order;
import com.store.storeadmin.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public List<Order> findOrders(){
        List<Order> list = orderMapper.findOrders();
        //根据status来判断是否已支付：0-未支付，1-已支付，2-已取消，3-已关闭，4-已完成
        for (Order order : list) {
            Integer status = order.getStatus();
            if (status == 0){
                order.setStrstatus("未支付");
            }else if (status == 1){
                order.setStrstatus("已支付");
            }
            else if (status == 2){
                order.setStrstatus("已取消");
            }
            else if (status == 3){
                order.setStrstatus("已关闭");
            }
            else if (status == 4){
                order.setStrstatus("已完成");
            }
            // 将省、市、区、地址合并为一个详细地址
            order.setAddress(order.getRecvProvince()
                    + order.getRecvCity()
                    + order.getRecvArea()
                    + order.getRecvAddress() );
        }
        return list;

    }

    public Result deleteByOid(Integer oid){
        Integer integer = orderMapper.deleteByOid(oid);
        if (integer < 1){
            return Result.fail(4004,"删除出错了");
        }
        return Result.success(null);
    }
}
