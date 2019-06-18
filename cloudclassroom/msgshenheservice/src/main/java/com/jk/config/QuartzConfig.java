package com.jk.config;

import com.jk.common.Quartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Package com.jk.config
 * @作者 韩慧鑫
 * @创建时间 2019/6/17 19:21
 */
@Configuration
public class QuartzConfig {
   /* @Bean
    public JobDetail teatQuartzDetail(){
        return JobBuilder.newJob(Quartz.class).withIdentity("testQuartz").storeDurably().build();
    }

    @Bean
    public Trigger testQuartzTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10)  //设置时间周期单位秒
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(teatQuartzDetail())
                .withIdentity("testQuartz")
                .withSchedule(scheduleBuilder)
                .build();
    }*/
}
