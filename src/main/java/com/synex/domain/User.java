package com.synex.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="UserS")
public class User {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long userId;
	
	private String username;
	

	private String <your password>;
	

	private String email;
	
	private String mobile;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="user_role")
	private Set<Role> roles = new HashSet<>();


	public User() {
		super();
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return <your password>;
	}


	public void setPassword(String <your password>) {
		this.<your password> = <your password>;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", <your password>=" + <your password> + ", email=" + email
				+ ", mobile=" + mobile + ", roles=" + roles + "]";
	}
	
}
