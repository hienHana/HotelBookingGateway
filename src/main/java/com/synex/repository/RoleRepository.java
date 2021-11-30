package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.synex.domain.Role;


public interface RoleRepository extends JpaRepository<Role, Integer>{
	@Query(value="select * from role where roleName=?1", nativeQuery=true)
	public Role findRoleByName(String name);
}
