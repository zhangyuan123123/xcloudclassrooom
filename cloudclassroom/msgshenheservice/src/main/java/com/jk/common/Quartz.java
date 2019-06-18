package com.jk.common;

import com.jk.model.ComQuartz;
import com.jk.service.ClassRoomServiceImpl;
import com.jk.util.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;


import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Package com.jk.common
 * @作者 韩慧鑫
 * @创建时间 2019/6/17 15:57
 */
@Component
public class Quartz{

    @Autowired
    private StringRedisTemplate redis;

    @Scheduled(fixedRate = 5000)
    public void scheduled1 (){
        ComQuartz comQuartz = new ComQuartz();
       // System.out.print(comQuartz);
        ValueOperations<String, String> jedis = redis.opsForValue();
        if (jedis.get("statusnumber")==null){
            System.out.print("未触发");
           // System.out.print(comQuartz.getStatusnumber());
        }else if(jedis.get("statusnumber").equals("1")){
            if (jedis.get(jedis.get("goodNumber"))==null){
                //调短信接口
                System.out.print(new Date());
                Map<String, Object> hashMap = new HashMap<>();
                hashMap.put("mobile",jedis.get("userPhone"));
                hashMap.put("tpl_id","166248");
                hashMap.put("tpl_value","%23code%23%3d"+"尊敬的用户，您租车已到期，请及时还车");
                hashMap.put("key","010129c37a935cfe33df53fcda585277");
                String s = HttpClient.sendGet("http://v.juhe.cn/sms/send", hashMap);
                jedis.set("statusnumber","null");
                return ;
            }else{
                System.out.print("未到时间");
            }
        }
    }

}
