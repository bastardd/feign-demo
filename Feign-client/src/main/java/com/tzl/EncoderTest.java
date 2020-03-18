package com.tzl;

import feign.Feign;
import feign.gson.GsonEncoder;

/**
 * feign的编码和解码的测试
 */
public class EncoderTest {

    public static void main(String[] args) {
        PersonClient personClient = Feign.builder()
                .encoder(new GsonEncoder())
                .target(PersonClient.class,"http://localhost:8080/");
        //创建带参数的实例
        PersonClient.Person person = new PersonClient.Person();
        person.personId = 3;
        person.personName = "张明福";
        String response = personClient.createPerson(person);
        System.out.println(response);
    }

}
