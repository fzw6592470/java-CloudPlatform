package com.genvict.online.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.genvict.online.utility.Product;
import com.genvict.online.utility.User;

@Component
public class UserServiceFallback implements UserService {
	
	@Override
    public List<User> findAll() {
        return Collections.emptyList();
    }

    @Override
    public User loadByLoginName(@PathVariable("loginName") String loginName) {
        return new User("error", "未知", "something-error-Fallback", "who has down?");
    }

}
