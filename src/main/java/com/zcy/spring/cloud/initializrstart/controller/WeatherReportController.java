package com.zcy.spring.cloud.initializrstart.controller;

import com.zcy.spring.cloud.initializrstart.service.CityDataService;
import com.zcy.spring.cloud.initializrstart.service.WeatherDataService;
import com.zcy.spring.cloud.initializrstart.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * WeatherController
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {
    @Autowired
    WeatherDataService weatherDataService;

    @Autowired
    WeatherReportService weatherReportService;

    @Autowired
    CityDataService cityDataService;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView  getReportByCityId(@PathVariable("cityId") String cityId, Model model)throws Exception{
        model.addAttribute("title","天气预报");
        model.addAttribute("cityId",cityId);
        model.addAttribute("cityList",cityDataService.listCity());
        model.addAttribute("report",weatherReportService.getDateByCityId(cityId));
        return new  ModelAndView("weather/report","reportModel",model);
    }
}
