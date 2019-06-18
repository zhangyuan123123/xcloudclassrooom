package com.jk.service.zys;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * 积极思考造成积极人生，消极思考造成消极人生
 *
 * @author 赵苑辰
 * @title: ClassClientService
 * @date 2019/6/18  10:40
 */
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
    void adddiscountcoupon(@RequestBody CouponModel couponModel);
    @RequestMapping("finddiscountcouponById")
    CouponModel finddiscountcouponById(@RequestParam("id") Integer id);
    @RequestMapping("updatediscountcoupon")
    void updatediscountcoupon(@RequestBody CouponModel couponModel);
    @RequestMapping("exuserrefer")
    HashMap<String, Object> exuserrefer(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit);
}
