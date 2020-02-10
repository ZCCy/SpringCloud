package com.zcy.spring.cloud.initializrstart.vo;

import java.io.Serializable;

/**
 * 昨日天气
 * @author zcy
 */
public class Yesterday implements Serializable {
    private static final long serialVersionUID = 1l ;

    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;

    public String getDate() {
        return date;
    }

    public Yesterday setDate(String date) {
        this.date = date;
        return this;
    }

    public String getHigh() {
        return high;
    }

    public Yesterday setHigh(String high) {
        this.high = high;
        return this;
    }

    public String getFx() {
        return fx;
    }

    public Yesterday setFx(String fx) {
        this.fx = fx;
        return this;
    }

    public String getLow() {
        return low;
    }

    public Yesterday setLow(String low) {
        this.low = low;
        return this;
    }

    public String getFl() {
        return fl;
    }

    public Yesterday setFl(String fl) {
        this.fl = fl;
        return this;
    }

    public String getType() {
        return type;
    }

    public Yesterday setType(String type) {
        this.type = type;
        return this;
    }
}
