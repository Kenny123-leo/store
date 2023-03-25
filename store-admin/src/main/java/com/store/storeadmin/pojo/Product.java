package com.store.storeadmin.pojo;

import lombok.Data;

@Data
public class Product {
    private Integer id;
    private String itemType;
    private Long price;
    private Integer num;
}
