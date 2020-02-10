package com.zcy.spring.cloud.initializrstart.vo;

import java.io.Serializable;

public class WeatherResponse implements Serializable {
    private static final long serialVersionUID = 1l ;

    private Weather data;
    private Integer status;
    private String desc;

    public Weather getData() {
        return data;
    }

    public WeatherResponse setData(Weather data) {
        this.data = data;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public WeatherResponse setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public WeatherResponse setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}
