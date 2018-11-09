package com.sb_ss_myb.frame.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sb_ss_myb.frame.dao.RoleDao;
import com.sb_ss_myb.frame.dao.UserDao;
import com.sb_ss_myb.frame.domain.SbssRole;
import com.sb_ss_myb.frame.domain.SbssUser;

@Service
public class CustomUserService implements UserDetailsService {

	@Autowired
	UserDao userDao;
	
	@Autowired
    RoleDao roleDao;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		SbssUser user = userDao.queryUserByUserName(username);
		if (user != null) {
			
			List<SbssRole> list = roleDao.queryRolebyUserId(user.getId());
			List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			for (SbssRole sbssRole : list) {
				if (sbssRole != null && sbssRole.getName()!=null) {
					GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(sbssRole.getId() + "");
					grantedAuthorities.add(grantedAuthority);
				}
			}
			
			return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
		} else {
			throw new UsernameNotFoundException(username + " do not exist!");
		}
	}

}
