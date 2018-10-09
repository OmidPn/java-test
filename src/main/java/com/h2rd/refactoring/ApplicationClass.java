package com.h2rd.refactoring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class ApplicationClass
{
    
    public static void main(String[] args) {
        SpringApplication.run(ApplicationClass.class, args);
    }
//    public static void main(String[] args) {
//        SpringApplication.run(applicationClass, args);
//    }
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(applicationClass);
//    }
//
//    private static Class<ApplicationClass> applicationClass = ApplicationClass.class;
}
