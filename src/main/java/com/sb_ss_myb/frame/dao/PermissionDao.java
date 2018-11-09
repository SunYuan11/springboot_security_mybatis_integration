package com.sb_ss_myb.frame.dao;

import java.util.List;

import com.sb_ss_myb.frame.domain.Permission;

public interface PermissionDao {
	
	public List<Permission> findAll();
	
	public List<Permission> findByAdminUserId(int userId);

}
