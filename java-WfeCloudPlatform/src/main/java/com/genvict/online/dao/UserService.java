package com.genvict.online.dao;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.genvict.online.utility.Product;
import com.genvict.online.utility.User;

@FeignClient(name ="java-wbe-cloud-platform", fallback = UserServiceFallback.class)
public interface UserService {
	@RequestMapping(value = "/users", method = RequestMethod.GET)
    List<User> findAll();

    @RequestMapping(value = "/users/{loginName}", method = RequestMethod.GET)
    User loadByLoginName(@PathVariable("loginName") String loginName);
}
