package com.zcy.spring.cloud.initializrstart.vo;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "county")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {
    @XmlAttribute(name = "weatherCode")
    private String cityId;

    @XmlAttribute(name = "name")
    private String cityName;

    @XmlAttribute(name = "id")
    private String cityCode;

    public String getCityId() {
        return cityId;
    }

    public City setCityId(String cityId) {
        this.cityId = cityId;
        return this;
    }

    public String getCityName() {
        return cityName;
    }

    public City setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public String getCityCode() {
        return cityCode;
    }

    public City setCityCode(String cityCode) {
        this.cityCode = cityCode;
        return this;
    }
}