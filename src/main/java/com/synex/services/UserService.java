package com.synex.services;

import com.synex.domain.User;

public interface UserService {
	public User findByUsername(String username);
	public User saveUser(User user);
}
