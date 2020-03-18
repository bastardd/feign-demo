package com.tzl;

import feign.RequestLine;

/**
 * 表示一个服务的接口
 */
public interface HelloClient {

    @RequestLine("GET /hello")
    String sayHello();
}
