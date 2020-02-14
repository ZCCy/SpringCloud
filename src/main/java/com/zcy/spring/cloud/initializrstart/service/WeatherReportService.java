package com.zcy.spring.cloud.initializrstart.service;

import com.zcy.spring.cloud.initializrstart.vo.Weather;

public interface WeatherReportService {
    Weather getDateByCityId(String cityId);
}
