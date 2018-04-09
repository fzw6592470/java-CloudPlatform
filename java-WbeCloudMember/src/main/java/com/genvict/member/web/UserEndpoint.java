package com.genvict.member.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.genvict.member.utility.User;

@RestController
@RequestMapping("/users")
public class UserEndpoint {
	protected Logger logger = LoggerFactory.getLogger(UserEndpoint.class);

    @Value("${server.port:18003}")
    private int serverPort = 18003;

    @RequestMapping(value = "/{loginName}", method = RequestMethod.GET)
    @ResponseBody
    public User detail(@PathVariable String loginName) {
        String memos = "I come form " + this.serverPort;
        logger.info(memos);
        try{
            Thread.sleep(1000000);
        }catch ( Exception e){
            logger.error(" hello two error",e);
        }
        return new User(loginName, loginName, "/avatar/default.png", memos);
    }

}
