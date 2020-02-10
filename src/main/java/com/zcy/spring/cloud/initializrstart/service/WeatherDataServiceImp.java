package com.zcy.spring.cloud.initializrstart.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zcy.spring.cloud.initializrstart.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.io.IOUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.io.InputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;

/**
 * 实现类
 */
@Service
public class WeatherDataServiceImp implements WeatherDataService {
    private static final String WEATHER_URL = "http://wthrcdn.etouch.cn/weather_mini?";
    private final static Logger logger = LoggerFactory.getLogger(WeatherDataService.class);
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final long TIME_OUT = 10l;

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
        String strBody = null;
        String key = url;
        ObjectMapper mapper = new ObjectMapper();
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        //先查缓存，如果缓存有，取出缓存数据
        if (stringRedisTemplate.hasKey(key)) {
            logger.info("Redis has data");
            strBody = ops.get(key);
        } else {
            //如果缓存没有，再调用服务接口来获取数据 先查缓存数据，
            logger.info("Redis don't have data");
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
            try {
                InputStream stream = new GZIPInputStream(conn.getInputStream());
                strBody = IOUtils.toString(stream, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            //数据写入缓存
            ops.set(key,strBody,TIME_OUT, TimeUnit.SECONDS);
        }
        //反序列化
        WeatherResponse resp = null;
        try {
            resp = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resp;
    }
}
