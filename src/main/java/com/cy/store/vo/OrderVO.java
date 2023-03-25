package com.cy.store.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderVO implements Serializable {
    // od.oid，od.recv_name,od.total_price,od.status,od.order_time,
    //      	odm.image,odm.title,odm.price,odm.num
    private Integer oid;
    private String recvName;
    private Long totalPrice;
    private Integer status;
    private Date orderTime;
    private String image;
    private String title;
    private Long price;
    private Integer num;
    private String strstatus;
}
