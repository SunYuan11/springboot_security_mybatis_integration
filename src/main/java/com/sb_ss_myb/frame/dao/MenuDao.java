package com.sb_ss_myb.frame.dao;

import java.util.List;
import java.util.Map;

import com.sb_ss_myb.frame.domain.SbssMenu;

public interface MenuDao {

	List<Map<String,Object>> queryAllAuthorities();
	
	List<SbssMenu> queryUserMenuByUsername(String username);
	
}
