package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class CouponModel {
    private Integer couponId;
    private String couponTitle;
    private Integer imgId;
    private String couponTimeliness;
    private Integer couponQuantity;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date couponStarttime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date couponEndtime;
    private Integer couponStatus;
    private String couponType;
    private Integer couponPrice;
    private String coupon;

    private String imgUrl;
}
