package com.jk.service.hhx;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Package com.jk.service.hhx
 * @作者 韩慧鑫
 * @创建时间 2019/6/12 16:28
 */
@FeignClient("msgshenhe-service")
public interface MsgShenHeService {
    @RequestMapping("findaptitude")
    HashMap<String,Object> findaptitude(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit,@RequestParam("name") String name);
    @RequestMapping("shenhejujue")
    void shenhejujue(@RequestParam("id") Integer id,@RequestParam("liyou") String liyou);
    @RequestMapping("tongguo")
    void shenhetongguo(@RequestParam("id") Integer id);
    @RequestMapping("findzucheliang")
    HashMap<String, Object> findzucheliang(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit);
    @RequestMapping("findzuchexinxi")
    HashMap<String, Object> findzuchexinxi(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit,@RequestParam("id") Integer id);
    @RequestMapping("orderrefer")
    HashMap<String, Object> orderrefer(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit);
    @RequestMapping("updateStatus")
    void updateStatus(@RequestParam("xid") Integer xid);
}
