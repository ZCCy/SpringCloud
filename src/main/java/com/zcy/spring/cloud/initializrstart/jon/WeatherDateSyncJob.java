package com.zcy.spring.cloud.initializrstart.jon;

import com.zcy.spring.cloud.initializrstart.service.CityDataService;
import com.zcy.spring.cloud.initializrstart.service.WeatherDataService;
import com.zcy.spring.cloud.initializrstart.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

public class WeatherDateSyncJob extends QuartzJobBean {
    @Autowired
    private CityDataService cityDataService;
    @Autowired
    private WeatherDataService weatherDataService;

    private final static Logger logger = LoggerFactory.getLogger(WeatherDateSyncJob.class);
    @Override
    protected void executeInternal(JobExecutionContext context)throws JobExecutionException {
       logger.info("Weather Data Sync Job");
        List<City> cityList = null;
        try{
            cityList = cityDataService.listCity();
        }catch (Exception e){
            logger.error("EXception!",e);
        }

        for(City city : cityList){
            String cityId = city.getCityId();
            logger.info("cityId:" + cityId);
            weatherDataService.syncDateByCityId(cityId);
        }
        logger.info("end");
    }
}
