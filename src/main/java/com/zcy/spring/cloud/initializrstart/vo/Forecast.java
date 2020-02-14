package com.zcy.spring.cloud.initializrstart.vo;

import java.io.Serializable;

/**
 * 未来天气
 * @author zcy
 */
public class Forecast implements Serializable {
    //private static final long serialVersionUID = 1l ;

    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;

    public String getDate() {
        return date;
    }

    public Forecast setDate(String date) {
        this.date = date;
        return this;
    }

    public String getHigh() {
        return high;
    }

    public Forecast setHigh(String high) {
        this.high = high;
        return this;
    }

    public String getFengli() {
        String num = fengli.substring(9);
        String str1=num.substring(0, num.indexOf("]"));
        return str1;
    }

    public Forecast setFengli(String fengli) {
        this.fengli = fengli;
        return this;
    }

    public String getLow() {
        return low;
    }

    public Forecast setLow(String low) {
        this.low = low;
        return this;
    }

    public String getFengxiang() {
        return fengxiang;
    }

    public Forecast setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
        return this;
    }

    public String getType() {
        return type;
    }

    public Forecast setType(String type) {
        this.type = type;
        return this;
    }
}
