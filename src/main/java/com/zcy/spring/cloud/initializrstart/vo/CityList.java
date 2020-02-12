package com.zcy.spring.cloud.initializrstart.vo;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * City List
 * @author zcy
 */
@XmlRootElement(name = "city")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {
    @XmlElement(name = "county")
    private List<City> cityList;

    public List<City> getCityList() {
        return cityList;
    }

    public CityList setCityList(List<City> cityList) {
        this.cityList = cityList;
        return this;
    }
}
