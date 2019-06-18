package com.jk.model;

import lombok.Data;

/**
 * @Package com.jk.model
 * @作者 韩慧鑫
 * @创建时间 2019/6/18 9:34
 */
@Data
public class ComQuartz {
    String comnumber;
    Integer statusnumber;
    Integer userId;
    String userPhone;

    public  ComQuartz(String comnumber, Integer statusnumber, Integer userId, String userPhone) {
        this.comnumber = comnumber;
        this.statusnumber = statusnumber;
        this.userId = userId;
        this.userPhone = userPhone;
    }
    public ComQuartz(){

    }
}
