package com.tzl;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

/**
 * 用 CXF 来发布和调用 Web Service
 */
public class CxfClient {

    public static void main(String[] args) throws IOException {
        //创建webClient
        WebClient webClient = WebClient.create("http://localhost:8080/person/1");
        //获取响应
        Response response = webClient.get();
        //获取响应内容
        InputStream inputStream = (InputStream) response.getEntity();
        String content = IOUtils.readStringFromStream(inputStream);
        //输出字符串
        System.out.println(content);
    }
}
