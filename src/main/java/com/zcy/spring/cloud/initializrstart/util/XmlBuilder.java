package com.zcy.spring.cloud.initializrstart.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

public class XmlBuilder {
    /**
     * 将xml转成指定的POJO
     * @param clazz
     * @param sxmlStr
     * @return
     * @throws Exception
     */
    public static Object xmsStrToObject(Class<?> clazz,String xmlStr) throws Exception{
        Object xmlObject = null;
        Reader reader = null;
        JAXBContext context = JAXBContext.newInstance(clazz);

        // XML 转为对象的接口
        Unmarshaller unmarshaller = context.createUnmarshaller();

        reader = new StringReader(xmlStr);
        xmlObject = unmarshaller.unmarshal(reader);

        if (null != reader) {
            reader.close();
        }

        return xmlObject;
    }
}
