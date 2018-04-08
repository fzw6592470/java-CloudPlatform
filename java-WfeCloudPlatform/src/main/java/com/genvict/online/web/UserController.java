package com.genvict.online.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.genvict.online.dao.UserService;
import com.genvict.online.utility.User;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
    private UserService UserService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> list() {
        return this.UserService.findAll();
    }

    @RequestMapping(value = "/{itemCode}", method = RequestMethod.GET)
    public User detail(@PathVariable String itemCode) {
        return this.UserService.loadByLoginName(itemCode);
    }
}
