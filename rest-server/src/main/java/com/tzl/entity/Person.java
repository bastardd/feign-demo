package com.tzl.entity;

import lombok.Data;

@Data
public class Person {
    public Integer personId;
    public String personName;

    public Person(){}


    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                '}';
    }
}
