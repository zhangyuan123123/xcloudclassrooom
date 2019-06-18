package com.jk.service;

import java.util.HashMap;

/**
 * @Package com.jk.service
 * @作者 韩慧鑫
 * @创建时间 2019/6/12 16:34
 */
public interface ClassRoomService {
    HashMap<String,Object> findaptitude(Integer page,Integer limit,String name);

    void shenhejujue(Integer id, String liyou);

    void shenhetongguo(Integer id);

    HashMap<String, Object> findzucheliang(Integer page,Integer limit);

    HashMap<String, Object> findzuchexinxi(Integer page, Integer limit,Integer id);

    HashMap<String, Object> orderrefer(Integer page, Integer limit);

    void updateStatus(Integer xid);
}
