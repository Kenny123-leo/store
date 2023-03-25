package com.cy.store.vo;

import lombok.Data;

import java.io.Serializable;

/** 购物车数据的VO类（ValueObject） */
@Data
public class CartVO implements Serializable {
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Long price;
    private Integer num;
    private String image;
    private String title;
    private Long realPrice;
}
