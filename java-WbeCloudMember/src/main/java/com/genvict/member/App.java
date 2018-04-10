package com.genvict.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient
@MapperScan("com.genvict.member.mapper")
@ComponentScan(basePackages = "com.genvict.member")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class App  extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
        System.out.println( "Hello Member!" );
    }
}
