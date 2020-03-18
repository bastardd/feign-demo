package com.tzl;

import feign.Feign;

/**
 * ，Feign 实际上会帮我们动态生成代理类。Feign 使用的是 JDK 的动态
        代理，生成的代理类，会将请求的信息封装，交给 feign.Client 接口发送请求，而该接口的
        默认实现类，最终会使用 java.net.HttpURLConnection 来发送 HTTP 请求
 */
public class HelloMain {

    public static void main(String[] args) {
        HelloClient helloClient = Feign.builder().target(HelloClient.class,"http://localhost:8080/");
        System.out.println(helloClient.sayHello());
    }
}
