package com.tzl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RestServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RestServerApplication.class).run(args);
    }

}
