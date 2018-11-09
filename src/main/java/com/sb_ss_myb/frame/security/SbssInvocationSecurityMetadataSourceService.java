package com.sb_ss_myb.frame.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import com.sb_ss_myb.frame.service.MenuService;

@Service
public class SbssInvocationSecurityMetadataSourceService implements
		FilterInvocationSecurityMetadataSource {

	@Autowired
	private MenuService menuService;

	/** URL与权限对应 */
	private static Map<String, Collection<ConfigAttribute>> resourceMap = 
			new LinkedHashMap<String, Collection<ConfigAttribute>>();

	@PostConstruct
	public void loadResourceDefine() {
		synchronized (SbssInvocationSecurityMetadataSourceService.resourceMap) {
			SbssInvocationSecurityMetadataSourceService.resourceMap.clear();
			List<Map<String, Object>> list = this.menuService
					.queryAllAuthorities();
			if (list != null) {
				String url, roleid;
				Collection<ConfigAttribute> collection = null;
				for (Map<String, Object> map : list) {
					url = map.get("URL").toString();
					roleid = map.get("ROLE_ID").toString();
					collection = SbssInvocationSecurityMetadataSourceService.resourceMap
							.get(url);
					if (collection == null) {
						collection = new ArrayList<ConfigAttribute>();
						SbssInvocationSecurityMetadataSourceService.resourceMap
								.put(url, collection);
					}
					// 此处添加的信息将会作为MyAccessDecisionManager类的decide的第三个参数
					collection.add(new SecurityConfig(roleid));
				}
			}

		}

	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	/**
	 * 返回所请求资源所需要的权限
	 * 
	 * @param object
	 *            此参数封装了访问的URL(请求的资源)
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		// 处理一下,把?后的去掉
		if (requestUrl.indexOf("?") != -1)
			requestUrl = requestUrl.substring(0, requestUrl.indexOf("?"));

		// 返回的所有权限资源
		PathMatcher matcher = new AntPathMatcher();

		for (String url : resourceMap.keySet()) {
			// 如果有匹配的URL时
			if (matcher.match(url, requestUrl)) {
				return resourceMap.get(url);
			}
		}

		// 资源没有被保护，放行
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
