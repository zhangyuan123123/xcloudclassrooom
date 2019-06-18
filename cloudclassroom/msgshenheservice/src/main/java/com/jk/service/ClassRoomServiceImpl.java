package com.jk.service;

import com.jk.common.Quartz;
import com.jk.mapper.ClassRoomMapper;
import com.jk.model.ComQuartz;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Package com.jk.service
 * @作者 韩慧鑫
 * @创建时间 2019/6/12 16:34
 */
@Service
public class ClassRoomServiceImpl implements ClassRoomService{
    @Autowired
    private StringRedisTemplate redis;

    @Autowired
    private ClassRoomMapper classRoomMapper;

    @Override
    public HashMap<String,Object> findaptitude(Integer page,Integer limit,String name) {
        HashMap<String,Object> map=new HashMap<String,Object>();
        if(StringUtils.isNotBlank(name)){//判断某字符串是否不为空且长度不为0且不由空白符(whitespace)构成，等于!isBlank(String str)
            List<LinkedHashMap> list = classRoomMapper.findaptitudeName((page-1)*limit, limit,name);
            Long count=classRoomMapper.getAptitudeSumSize();
            map.put("count",count);
            map.put("data",list);
            map.put("code",0);
            map.put("msg","");

        }else {
            List<LinkedHashMap> list = classRoomMapper.findaptitude((page-1)*limit, limit);
            Long count=classRoomMapper.getAptitudeSumSize();
            map.put("count",count);
            map.put("data",list);
            map.put("code",0);
            map.put("msg","");
        }
        return map;
    }

    @Override
    public void shenhejujue(Integer id, String liyou) {
        classRoomMapper.shenhejujue(id,liyou);
    }

    @Override
    public void shenhetongguo(Integer id) {
        classRoomMapper.shenhetongguo(id);
    }

    @Override
    public HashMap<String, Object> findzucheliang(Integer page,Integer limit) {
        HashMap<String,Object> map=new HashMap<String,Object>();
        List<LinkedHashMap> list = classRoomMapper.findzucheliang((page-1)*limit, limit);
        Long count=classRoomMapper.getzucheliangSumSize();
        map.put("count",count);
        map.put("data",list);
        map.put("code",0);
        map.put("msg","");
        return map;
    }

    @Override
    public HashMap<String, Object> findzuchexinxi(Integer page, Integer limit,Integer id) {
        HashMap<String,Object> map=new HashMap<String,Object>();
        List<LinkedHashMap> list = classRoomMapper.findzuchexinxi((page-1)*limit, limit,id);
        Long count=classRoomMapper.getzuchexinxi();
        map.put("count",count);
        map.put("data",list);
        map.put("code",0);
        map.put("msg","");
        return map;
    }

    @Override
    public HashMap<String, Object> orderrefer(Integer page, Integer limit) {
        HashMap<String,Object> map=new HashMap<String,Object>();
        List<LinkedHashMap> list = classRoomMapper.orderrefer((page-1)*limit,limit);
        Long count=classRoomMapper.ordercount();
        map.put("count",count);
        map.put("data",list);
        map.put("code",0);
        map.put("msg","");
        return map;
    }

    @Override
    public void updateStatus(Integer xid) {
        ValueOperations<String, String> jedis = redis.opsForValue();
        Integer status= classRoomMapper.updateStatus(xid);
        HashMap<String,Object> map=classRoomMapper.refer(xid);
        HashMap<String,Object> map1=classRoomMapper.userrefer(xid);
        Object object = map.get("goodUserId");
        Integer goodUserId = Integer.parseInt(String.valueOf(object));
        String  userPhone = (String) map1.get("userPhone");
        String  goodNumber = (String) map.get("goodNumber");
        //System.out.print(map);
        Date endTime = (Date) map.get("endTime");
        Date createTime = (Date) map.get("createTime");
        long time = endTime.getTime();
        long time1 = createTime.getTime();
        long time2=time-time1;
        if(status==1){
            ComQuartz quartz = new ComQuartz(goodNumber,1,goodUserId,userPhone);
            jedis.set("goodNumber",goodNumber);
            jedis.set("statusnumber","1");
            jedis.set("goodUserId",goodUserId+"");
            jedis.set("userPhone",userPhone);
            String s = new Date().toString();
            jedis.set(goodNumber,s);
            redis.expire(goodNumber,time2 , TimeUnit.MILLISECONDS);
            redis.expire("statusnumber",time2 , TimeUnit.MILLISECONDS);
            //System.out.print(quartz);
        }

    }
}
