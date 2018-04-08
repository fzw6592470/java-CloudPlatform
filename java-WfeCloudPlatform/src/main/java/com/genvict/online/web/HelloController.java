package com.genvict.online.web;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.genvict.online.dao.HelloRemote;

@RestController
@RefreshScope
public class HelloController {
	
	protected Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	HelloRemote HelloRemote;
	
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    
    @Value("${cuigl.hello}")
    private String hello;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
    	
    	System.out.print("this.hello:" + this.hello);
    	return HelloRemote.hello();
//        return restTemplate.getForEntity("http://JAVA-WBE-CLOUD-PLATFORM/hello", String.class).getBody();
    }
    
    @RequestMapping(value = "/helloEx", method = RequestMethod.GET)
    public String helloEx() {
        ServiceInstance instance = this.loadBalancerClient.choose("JAVA-WBE-CLOUD-PLATFORM");
        URI helloUri = URI.create(String.format("http://%s:%s/hello", instance.getHost(), instance.getPort()));        
        logger.info("Target service uri = {}. ", helloUri.toString());
        return new RestTemplate().getForEntity(helloUri, String.class).getBody();
    }

}