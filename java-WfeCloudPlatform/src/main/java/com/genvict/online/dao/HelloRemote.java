package com.genvict.online.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "java-wbe-cloud-platform")
public interface HelloRemote {
	@RequestMapping(value = "/hello")
    public String hello();
}
