package com.genvict.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MainApp {
	
	public static void main( String[] args )
    {
    	SpringApplication.run(MainApp.class, args);
        System.out.println( "Hello Eureka Two!" );
    }
}
