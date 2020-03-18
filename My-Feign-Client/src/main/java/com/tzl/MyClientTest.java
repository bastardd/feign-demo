package com.tzl;

import feign.Feign;
import feign.gson.GsonEncoder;

public class MyClientTest {
    public static void main(String[] args) {
        PersonClient personClient = Feign.builder()
                .encoder(new GsonEncoder())
                .client(new MyFeignClient())
                .target(PersonClient.class,"http://localhost:8080/");
        //请求hello
        String result = personClient.sayHello();
        System.out.println("接口响应内容----" + result);
    }
}
