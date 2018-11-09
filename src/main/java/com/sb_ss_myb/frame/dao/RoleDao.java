package com.sb_ss_myb.frame.dao;

import java.util.List;

import com.sb_ss_myb.frame.domain.SbssRole;

public interface RoleDao {

	public List<SbssRole> queryRolebyUserId(int userid);
}
