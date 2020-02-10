package com.zcy.spring.cloud.initializrstart.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zcy.spring.cloud.initializrstart.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.io.InputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

/**
 * 实现类
 */
@Service
public class WeatherDataServiceImp implements WeatherDataService {
    private static final String WEATHER_URL = "http://wthrcdn.etouch.cn/weather_mini?";
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String url = WEATHER_URL + "citykey=" + cityId;
        return this.doGetWeather(url);
    }

    @Override
    public WeatherResponse getDataVyCityName(String cityName) {
        String url = WEATHER_URL + "city=" + cityName;
        return this.doGetWeather(url);
    }

    private WeatherResponse doGetWeather(String url) {
        URL realUrl = null;
        try {
            realUrl = new URL(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
// 打开和URL之间的连接
        HttpURLConnection conn = null;
// 发送POST请求必须设置如下两行
        try {
            conn = (HttpURLConnection) realUrl.openConnection();
            conn.setRequestMethod("GET");// 提交模式
        } catch (Exception e) {
            e.printStackTrace();
        }

        conn.setDoInput(true);
        conn.setDoOutput(false);
        conn.setUseCaches(false);
        conn.setRequestProperty("Connection", "close");
        conn.setConnectTimeout(3000);  //设置连接主机超时（单位：毫秒）
        conn.setReadTimeout(2000);     //设置从主机读取数据超时（单位：毫秒）

        String str = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream stream = new GZIPInputStream(conn.getInputStream());
            str = IOUtils.toString(stream, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        WeatherResponse resp = null;
        try {
            resp = mapper.readValue(str, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resp;
    }
}
