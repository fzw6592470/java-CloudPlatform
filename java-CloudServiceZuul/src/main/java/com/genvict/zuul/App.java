package com.genvict.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.genvict.zuul.filter.PasswordFilter;
import com.genvict.zuul.filter.TokenFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableCircuitBreaker
@EnableDiscoveryClient
public class App 
{
	
	@Bean
	public PasswordFilter passwordFilter()
	{
		return new PasswordFilter();
	}
	
	@Bean
	public TokenFilter tokenFilter()
	{
		return new TokenFilter();
	}
	
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
        System.out.println( "Hello Zuul!" );
    }
}
