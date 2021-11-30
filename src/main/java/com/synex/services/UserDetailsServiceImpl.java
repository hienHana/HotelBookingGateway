package com.synex.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;

import com.synex.domain.Role;
import com.synex.domain.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("in UserDetailsServiceImpl- username: "+username);
		User user = userService.findByUsername(username);
		System.out.println("in UserDetailsServiceImpl "+user.getUsername());
		Set<GrantedAuthority> ga = new HashSet<>();
		Set<Role> roles = user.getRoles();
		for(Role role:roles) {
			System.out.println("role.getRoleName() "+role.getRoleName());
			ga.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),ga);
	}

}
