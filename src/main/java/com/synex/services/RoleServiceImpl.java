package com.synex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Role;
import com.synex.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired RoleRepository roleRepository;
	
	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role findRoleByName(String name) {
		return roleRepository.findRoleByName(name);
	}

}
