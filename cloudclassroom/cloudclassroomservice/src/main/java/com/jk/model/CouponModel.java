package com.jk.model;

import lombok.Data;

@Data
public class CouponModel {
    private Integer couponId;
    private String couponTitle;
    private Integer imgId;
    private String couponTimeliness;
    private Integer couponQuantity;
    private String couponStarttime;
    private String couponEndtime;
    private Integer couponStatus;
    private String couponType;
    private Integer couponPrice;
    private String coupon;

    private String imgUrl;
}
