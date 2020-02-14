package com.zcy.spring.cloud.initializrstart.service;

import com.zcy.spring.cloud.initializrstart.vo.Weather;
import com.zcy.spring.cloud.initializrstart.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
    @Autowired
    WeatherDataService weatherDataService;
    @Override
    public Weather getDateByCityId(String cityId) {
        WeatherResponse resp = weatherDataService.getDataByCityId(cityId);
        return resp.getData();
    }
}
