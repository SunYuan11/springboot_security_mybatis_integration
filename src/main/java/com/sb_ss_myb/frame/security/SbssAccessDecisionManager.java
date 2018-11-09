package com.sb_ss_myb.frame.security;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class SbssAccessDecisionManager implements AccessDecisionManager {

	/**
	 * 最重要的就是decide方法 ，它负责去决策你是否有权限去访问你访问的资源。
	 * 第一个参数Authentication 是你登陆的角色所具有的权限列表。
	 * 第二个参数是你访问的url。
	 * 第三个参数是访问这个url所需要的权限列表。
	 */
	@Override
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes) throws AccessDeniedException,
			InsufficientAuthenticationException {
		if(null== configAttributes || configAttributes.size() <=0) {
            return;
        }
		
		for (ConfigAttribute configAttribute : configAttributes) { // 所请求的资源需要的权限(一个资源对多个权限)
			for (GrantedAuthority ga : authentication.getAuthorities()) { // 用户所拥有的权限(一个用户对多个权限)
				if (ga.getAuthority().equals(configAttribute.getAttribute())) { // 判断是否有匹配的权限(此处用的是角色ID)
					return;
				}
			}
		}
		throw new AccessDeniedException("没有权限访问！");
		
	}

	@Override
	public boolean supports(ConfigAttribute arg0) {
		return true;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
