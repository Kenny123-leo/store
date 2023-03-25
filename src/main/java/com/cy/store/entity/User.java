package com.cy.store.entity;

import lombok.Data;

import java.io.Serializable;
/** 用户的实体类:SpringBoot约定大于配置 **/
@Data
public class User extends BaseEntity implements Serializable {
    private Integer uid;
    private String username;
    private String password;
    private String salt;
    private String phone;
    private String email;
    private Integer gender;
    private String avatar;
    private Integer isDelete;

    // get和set方法、equals和hashCode（）方法，toString方法

}
