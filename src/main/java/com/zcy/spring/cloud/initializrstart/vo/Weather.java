package com.zcy.spring.cloud.initializrstart.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author zcy
 * 天气
 */
public class Weather implements Serializable {
    private static final long serialVersionUID = 1l ;

    private String city;
    private String aqi;
    private String ganmao;
    private String wendu;
    private Yesterday yesterday;
    private List<Forecast> forecast;

    public String getCity() {
        return city;
    }

    public Weather setCity(String city) {
        this.city = city;
        return this;
    }

    public String getAqi() {
        return aqi;
    }

    public Weather setAqi(String aqi) {
        this.aqi = aqi;
        return this;
    }

    public String getGanmao() {
        return ganmao;
    }

    public Weather setGanmao(String ganmao) {
        this.ganmao = ganmao;
        return this;
    }

    public String getWendu() {
        return wendu;
    }

    public Weather setWendu(String wendu) {
        this.wendu = wendu;
        return this;
    }

    public Yesterday getYesterday() {
        return yesterday;
    }

    public Weather setYesterday(Yesterday yesterday) {
        this.yesterday = yesterday;
        return this;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public Weather setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
        return this;
    }
}
