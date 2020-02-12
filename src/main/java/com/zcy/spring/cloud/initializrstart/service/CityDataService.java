package com.zcy.spring.cloud.initializrstart.service;

import com.zcy.spring.cloud.initializrstart.vo.City;

import java.util.List;

public interface CityDataService {
    List<City> listCity() throws Exception;
}
