package com.genvict.app;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MainApp 
{
	
    public static void main( String[] args )
    {
    	SpringApplication.run(MainApp.class, args);
        System.out.println( "Hello Wbe App Cloud!" );
    }
}
