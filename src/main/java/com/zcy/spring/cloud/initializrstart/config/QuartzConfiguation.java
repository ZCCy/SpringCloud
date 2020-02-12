package com.zcy.spring.cloud.initializrstart.config;

import com.zcy.spring.cloud.initializrstart.jon.WeatherDateSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * quartzConfig
 * @author zcy
 */
@Configuration
public class QuartzConfiguation {

    //JobDetail
    @Bean
    public JobDetail weatherDataSyncDetail(){
        return JobBuilder.newJob(WeatherDateSyncJob.class).withIdentity("weatherDataSyncJob")
                .storeDurably().build();
    }
    //Trigger(触发)
    @Bean
    public Trigger weatherDataSyncTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(1800).repeatForever();
        return TriggerBuilder.newTrigger().forJob(weatherDataSyncDetail())
                .withIdentity("weatherDataSyncTrigger").withSchedule(scheduleBuilder).build();
    }
}
