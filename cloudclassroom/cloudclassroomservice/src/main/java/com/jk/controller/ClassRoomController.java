package com.jk.controller;

import com.jk.model.CouponModel;
import com.jk.service.ClassRoomService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import java.util.HashMap;

@Controller
public class ClassRoomController {
    @Resource
    private ClassRoomService classRoomService;

    /**
     * 查询优惠券的方法
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("refer")
    @ResponseBody
    public HashMap<String,Object> refer(Integer page, Integer limit){
        return classRoomService.refer(page,limit);
    }

    /**
     * 删除优惠券的方法
     * @param sid
     */
    @RequestMapping("deletecoupon")
    @ResponseBody
    public void deletecoupon(Integer sid){
        classRoomService.deletecoupon(sid);
    }
    @RequestMapping("adddiscountcoupon")
    @ResponseBody
    public  String adddiscountcoupon(@RequestBody CouponModel couponModel){
        classRoomService.adddiscountcoupon(couponModel);
        return null;
    }

    @RequestMapping("finddiscountcouponById")
    @ResponseBody
    public CouponModel finddiscountcouponById(Integer id){
        return classRoomService.finddiscountcouponById(id);
    }
    @RequestMapping("updatediscountcoupon")
    @ResponseBody
    public String updatediscountcoupon(@RequestBody CouponModel couponModel){
        classRoomService.updatediscountcoupon(couponModel);
        return null;
    }
    @RequestMapping("exuserrefer")
    @ResponseBody
    public HashMap<String,Object> exuserrefer(Integer page, Integer limit){
        return classRoomService.exuserrefer(page,limit);
    }
}
