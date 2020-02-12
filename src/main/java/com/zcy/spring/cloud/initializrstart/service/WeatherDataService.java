package com.zcy.spring.cloud.initializrstart.service;

import com.zcy.spring.cloud.initializrstart.vo.WeatherResponse;

/**
 * Weather Date Service
 */
public interface WeatherDataService {
    /**
     * 根据城市id来查询天气数据
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);
    /**
     * 更具城市名称来查询天气数据
     * @param cityName
     * @return
     */
    WeatherResponse getDataVyCityName(String cityName);


    /**
     * 根据城市id来跟新数据
     * @param cityId
     * @return
     */
    void syncDateByCityId(String cityId);
}
