package com.genvict.scheduledTasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
public class ScheduledApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(ScheduledApp.class, args);
        System.out.println( "Hello World!" );
    }
}
