package com.store.storeadmin.vo;

import lombok.Data;

@Data
public class UserInfoVO {
    private Integer uid;
    private String username;
    private String password;
    private String phone;
    private String provinceName;
    private String cityName;
    private String areaName;
    private String address;
}
