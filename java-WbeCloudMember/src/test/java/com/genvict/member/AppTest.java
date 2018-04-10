package com.genvict.member;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.genvict.member.domain.User;
import com.genvict.member.mapper.UserMapper;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest 
    extends TestCase
{
	@Autowired
    private UserMapper userMapper;

    @Test
    @Transactional
    public void test(){
    	User user = new User();
    	user.setUserId(12345);
    	user.setUserName("张三");
    	user.setPhone("18779453377");
    	user.setPassword("123456");
        userMapper.insert(user);
        User u = userMapper.selectByPrimaryKey(12345);
        Assert.assertEquals("张三", u.getUserName());
    }
}
