package com.genvict.member.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.genvict.member.domain.User;
import com.genvict.member.mapper.UserMapper;
import com.genvict.member.service.UserService;

@RestController
@RequestMapping("/users")
public class UserEndpoint {
	protected Logger logger = LoggerFactory.getLogger(UserEndpoint.class);

    @Value("${server.port:18003}")
    private int serverPort = 18003;
    
//    @Value("${cuigl.hello}")
//    private String hello;

//    @RequestMapping(value = "/login/{loginName}", method = RequestMethod.GET)
//    @ResponseBody
//    public User detail(@PathVariable String loginName) {
//        String memos = "I come form " + this.serverPort;
//        logger.info(memos);
//        return new User(loginName, loginName, "/avatar/default.png", memos);
//    }
    
    @Resource
    private UserService userService;
    
    @RequestMapping("/showUser")
    @ResponseBody
    public com.genvict.member.domain.User toIndex(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        com.genvict.member.domain.User user = this.userService.getUserById(userId);
        return user;
    }
}
