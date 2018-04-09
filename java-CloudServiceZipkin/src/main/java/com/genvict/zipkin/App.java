package com.genvict.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.annotation.SleuthAnnotationAutoConfiguration;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication(exclude = SleuthAnnotationAutoConfiguration.class)
@EnableEurekaClient
@EnableZipkinServer
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
        System.out.println( "Hello Zipkin!" );
    }
}
