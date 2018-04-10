package com.genvict.member.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.genvict.member.domain.User;
import com.genvict.member.mapper.UserMapper;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;
	
	public User getUserById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public boolean addUser(User record){
        boolean result = false;
        try {
        	userMapper.insertSelective(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
