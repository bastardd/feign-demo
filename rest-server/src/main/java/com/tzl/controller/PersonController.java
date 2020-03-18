package com.tzl.controller;

import com.tzl.entity.Person;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PersonController {

    @GetMapping("/person/{personId}")
    public Map<String,Object> getPerson(@PathVariable(value = "personId") String personId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("personName","张三");
        map.put("personId",personId);
        return map;
    }

//    @PostMapping(value = "/person/create",consumes = MediaType.APPLICATION_JSON_VALUE)
//    public String createPerson(Person person) {
//        System.out.println(person.getPersonId() + "-" + person.getPersonName());
//        return "Success, Person Id: " + person.getPersonId();
//    }

    @PostMapping(value = "/person/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createPerson(@RequestBody Person person) {
        System.out.println(person.getPersonId() + "-" + person.getPersonName());
        return "Success, Person Id: " + person.getPersonName();
    }


}
