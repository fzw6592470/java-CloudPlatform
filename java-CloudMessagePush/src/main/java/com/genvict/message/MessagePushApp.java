package com.genvict.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MessagePushApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(MessagePushApp.class, args);
        System.out.println( "Hello Message Push!" );
    }
}
