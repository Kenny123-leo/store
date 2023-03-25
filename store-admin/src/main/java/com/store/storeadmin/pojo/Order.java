package com.store.storeadmin.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Order implements Serializable {
    // od.oid，od.recv_name,od.total_price,od.status,od.order_time,
    //      	odm.image,odm.title,odm.price,odm.num
    private Integer oid;
    private String recvName;
    private String recvPhone;
    private String recvProvince;
    private String recvCity;
    private String recvArea;
    private String recvAddress;
    private String address;
    private Long totalPrice;
    private Integer status;
    private Date orderTime;
    private String strstatus;
}
