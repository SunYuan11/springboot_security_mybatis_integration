package com.sb_ss_myb.frame.dao;

import com.sb_ss_myb.frame.domain.SbssUser;
import com.sb_ss_myb.frame.domain.SysUser;

public interface UserDao {
	
	public SysUser findByUserName(String username);
	
	public SbssUser queryUserByUserName(String username);

}
