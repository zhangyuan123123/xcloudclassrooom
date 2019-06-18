package com.jk.service;

import com.jk.model.CouponModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@FeignClient("zysservice")
public interface ClassClientService {
    @RequestMapping("refer")
    HashMap<String, Object> refer(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit);

    @RequestMapping("deletecoupon")
    void deletecoupon(@RequestParam("sid") Integer sid);
    @RequestMapping("adddiscountcoupon")
    void adddiscountcoupon(@RequestBody  CouponModel couponModel);
    @RequestMapping("finddiscountcouponById")
    CouponModel finddiscountcouponById(@RequestParam("id") Integer id);
    @RequestMapping("updatediscountcoupon")
    void updatediscountcoupon(@RequestBody CouponModel couponModel);
    @RequestMapping("exuserrefer")
    HashMap<String, Object> exuserrefer(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit);
}
