package com.synex.services;

import com.synex.domain.Role;

public interface RoleService {
	public Role save(Role role);
	public Role findRoleByName(String name);
}
