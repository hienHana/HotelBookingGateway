package com.synex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.User;
import com.synex.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired UserRepository userRepository;

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	

}
