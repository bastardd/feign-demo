package com.tzl;


import com.sun.security.ntlm.Client;
import feign.Request;
import feign.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Collection;
import java.util.HashMap;

/**
 * 自定义feign
 * 简单展示了一下Feign的原理
 */
public class MyFeignClient implements feign.Client{

    public Response execute(Request request, Request.Options options) throws IOException {
        System.out.println("==== 这是自定义的 Feign 客户端");
            // 创建一个默认的客户端
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            // 获取调用的 HTTP 方法
            final String method = request.method();
            // 创建一个 HttpClient 的 HttpRequest
            HttpRequestBase httpRequest = new HttpRequestBase() {
                public String getMethod() {
                    return method;
                }
            };
            // 设置请求地址
            httpRequest.setURI(new URI(request.url()));
            // 执行请求，获取响应
            HttpResponse httpResponse = httpclient.execute(httpRequest);
            // 获取响应的主体内容
            byte[] body = EntityUtils.toByteArray(httpResponse.getEntity());
            // 将 HttpClient 的响应对象转换为 Feign 的 Response
            Response response = Response.builder()
                    .body(body)
                    .headers(new HashMap<String, Collection<String>>())
                    .status(httpResponse.getStatusLine().getStatusCode())
                    .build();
            return response;
        }catch (Exception e){
            throw new IOException(e);
        }
    }
}
