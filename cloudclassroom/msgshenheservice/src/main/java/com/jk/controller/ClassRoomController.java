package com.jk.controller;


import com.jk.service.ClassRoomService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Package com.jk.controller
 * @作者 韩慧鑫
 * @创建时间 2019/6/12 16:33
 */
@Controller
public class ClassRoomController {

    ;

    @Autowired
    private ClassRoomService classRoomService;
    @RequestMapping("findaptitude")
    @ResponseBody
    public HashMap<String,Object> findaptitude(Integer page,Integer limit,String name){
        HashMap<String,Object> map=classRoomService.findaptitude(page,limit,name);
        return map;
    }
    @RequestMapping("shenhejujue")
    @ResponseBody
    public String shenhejujue(Integer id, String liyou){
        classRoomService.shenhejujue(id,liyou);
        return null;
    }
    @RequestMapping("shenhetongguo")
    @ResponseBody
    public String shenhetongguo(Integer id) {
        classRoomService.shenhetongguo(id);
        return null;
    }
    @RequestMapping("findzucheliang")
    @ResponseBody
    public HashMap<String,Object> findzucheliang(Integer page,Integer limit) {
        HashMap<String,Object> hashMap= classRoomService.findzucheliang(page,limit);
        return hashMap;
    }
    @RequestMapping("findzuchexinxi")
    @ResponseBody
    public HashMap<String,Object> findzuchexinxi(Integer page,Integer limit,Integer id) {
        HashMap<String,Object> hashMap= classRoomService.findzuchexinxi(page,limit,id);
        return hashMap;
    }


    @RequestMapping("orderrefer")
    @ResponseBody
    public HashMap<String,Object> orderrefer(Integer page,Integer limit){
        return classRoomService.orderrefer(page,limit);
    }

    @RequestMapping("updateStatus")
    @ResponseBody
    public void updateStatus(Integer xid){
        classRoomService.updateStatus(xid);
    }
}
