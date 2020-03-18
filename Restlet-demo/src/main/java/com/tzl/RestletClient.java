package com.tzl;

import org.restlet.data.MediaType;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Restlet 是一个轻量级的 REST 框架，使用它可以发布和调用 REST 风格的 WebService
 */
public class RestletClient {
    public static void main(String[] args) throws IOException {
        ClientResource clientResource = new ClientResource("http://localhost:8080/person/1");
        // 调用 get 方法，服务端发布的是 GET
        Representation representation = clientResource.get(MediaType.APPLICATION_JSON);
        // 创建 JacksonRepresentation 实例，将响应转换为 Map
        JacksonRepresentation jr = new JacksonRepresentation(representation, HashMap.class);
        // 获取转换后的 Map 对象
        Map map = (HashMap)jr.getObject();
        // 输出结果
        System.out.println(map);
    }
}
