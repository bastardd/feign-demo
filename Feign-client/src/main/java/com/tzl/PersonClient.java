package com.tzl;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import lombok.Data;


public interface PersonClient {

    @RequestLine("GET /person/{personId}")
    Person findById(@Param("personId") Integer personId);

    @RequestLine("POST /person/create")
    @Headers("Content-Type: application/json")  //声明请求的内容类型为 JSON
    String createPerson(Person person);

    @Data
    class Person {
        Integer personId;
        String personName;
    }
}
