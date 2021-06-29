package com.cas.springboot;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// 外接tomcat
//@EnableCasClient
//@SpringBootApplication
//public class SpringMvcApplication extends SpringBootServletInitializer {
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(SpringMvcApplication.class);
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(SpringMvcApplication.class, args);
//    }
//
//}

@EnableCasClient
@SpringBootApplication
public class SpringMvcApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringMvcApplication.class, args);
    }
}