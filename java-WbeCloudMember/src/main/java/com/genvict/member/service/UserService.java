package com.genvict.member.service;

import com.genvict.member.domain.User;

public interface UserService {
	public User getUserById(int userId);

    boolean addUser(User record);
}
