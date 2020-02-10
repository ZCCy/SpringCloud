package com.zcy.spring.cloud.initializrstart.controller;

import com.zcy.spring.cloud.initializrstart.service.WeatherDataService;
import com.zcy.spring.cloud.initializrstart.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * WeatherController
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    WeatherDataService weatherDataService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId){
        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName){
        return weatherDataService.getDataVyCityName(cityName);
    }
}
