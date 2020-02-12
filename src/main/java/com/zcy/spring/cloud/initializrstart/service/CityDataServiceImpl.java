package com.zcy.spring.cloud.initializrstart.service;

import com.zcy.spring.cloud.initializrstart.util.XmlBuilder;
import com.zcy.spring.cloud.initializrstart.vo.City;
import com.zcy.spring.cloud.initializrstart.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> listCity() throws Exception {
       //读取文件内容
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader bf = new BufferedReader(
                new InputStreamReader(resource.getInputStream(),"utf-8"));
                 StringBuffer buffer = new StringBuffer();
                 String line = "";

                 while ( (line=bf.readLine()) !=null){
                     buffer.append(line);
                 }
                 bf.close();
        //XML转为java对象
        CityList cityList = (CityList) XmlBuilder.xmsStrToObject(CityList.class,buffer.toString());

        return cityList.getCityList();
    }
}
