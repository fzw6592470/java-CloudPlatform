package com.genvict.online;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigServer
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.print("Hello WbePlatform!");
    }

}