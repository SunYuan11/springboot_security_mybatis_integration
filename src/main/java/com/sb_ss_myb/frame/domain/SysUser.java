package com.sb_ss_myb.frame.domain;

import java.io.Serializable;
import java.util.List;

public class SysUser implements Serializable {
	
	private static final long serialVersionUID = 7170875238791640856L;

	private Integer id;
	
    private String username;
    
    private String password;
    
    private List<SysRole> roles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "SysUser [id=" + id + ", username=" + username + ", password="
				+ password + "]";
	}
}
