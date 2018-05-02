package com.lee.kafka.model;

import java.io.Serializable;

/**
 * @author yz.li
 * @date 2018/4/28
 */
public class User implements Serializable {
    private static final long serialVersionUID = 2082037603305763192L;

    private Integer id;

    private String name;

    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
