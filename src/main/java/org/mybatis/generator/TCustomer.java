/*
 * TCustomer.java
 * Copyright(C) 20xx-2019 xxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2019-04-05 Created
 */
package com.example.demo.entity;

/**
 * 客户表
 * 
 * @author Administrator
 * @date	2019-04-05
 */
public class TCustomer {

    /**
     * 主键
     */
    private Long id;
    /**
     * 客户名称
     */
    private String name;
    /**
     * 地址
     */
    private String address;
    /**
     * 电话
     */
    private String phone;
    /**
     * 传真
     */
    private String fax;
    /**
     * 邮编
     */
    private String postCode;
    /**
     * 联系人
     */
    private String contacts;
    /**
     * 备注
     */
    private String remark;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getPostCode() {
        return postCode;
    }
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    public String getContacts() {
        return contacts;
    }
    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
}