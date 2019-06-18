package com.jk.service;

import com.jk.model.CouponModel;

import java.util.HashMap;

public interface ClassRoomService {
    HashMap<String, Object> refer(Integer page, Integer limit);

    void deletecoupon(Integer sid);

    void adddiscountcoupon(CouponModel couponModel);

    CouponModel finddiscountcouponById(Integer id);

    void updatediscountcoupon(CouponModel couponModel);

    HashMap<String, Object> exuserrefer(Integer page, Integer limit);
}
