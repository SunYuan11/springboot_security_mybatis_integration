package com.sb_ss_myb.frame.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.sb_ss_myb.frame.security.SbssFilterSecurityInterceptor;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private SbssFilterSecurityInterceptor sbssFilterSecurityInterceptor;
	
	@Autowired
    UserDetailsService customUserService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(customUserService);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/font-awesome/**").permitAll()
			.antMatchers("/fonts/**").permitAll()
			.antMatchers("/img/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/favicon.ico").permitAll()
			
			.anyRequest().authenticated() // 任何请求,登录后可以访问 
			
			.and() 
			.formLogin()
			// .defaultSuccessUrl("/index", true) // 默认登录成功页面
			.loginPage("/login") 
			.loginProcessingUrl("/dologin") // 定义登录 action="dologin"
			.failureUrl("/login?error") 
			.permitAll() // 登录页面用户任意访问 
		
			.and() 
			.logout()
			//.logoutUrl("/dologout") // need post
			.logoutRequestMatcher(new AntPathRequestMatcher("/dologout"))
			/*
			 * 1.The URL that triggers log out to occur (default is "/logout"). 
			 * If CSRF protection is enabled (default), then the request must 
			 * also be a POST. This means that by default POST "/logout" is 
			 * required to trigger a log out. If CSRF protection is disabled, 
			 * then any HTTP method is allowed. 
			 * 
			 * <form action="dologout" method="post">
			 * 	   <input type="hidden" th:name="${_csrf.parameterName }" th:value="${_csrf.token }"/>
			 * 	   <input type="submit" value="LOGOUT"/>
			 * </form>
			 * 
			 * 2.It is considered best practice to use an HTTP POST on any action 
			 * that changes state (i.e. log out) to protect against CSRF attacks. 
			 * If you really want to use an HTTP GET, 
			 * you can use logoutRequestMatcher(new AntPathRequestMatcher(logoutUrl, "GET"));
			
			 */
			
			.logoutSuccessUrl("/login")
            .deleteCookies("JSESSIONID")
            .invalidateHttpSession(true)
			.permitAll() // 注销行为任意访问
			
			.and()
			.exceptionHandling().accessDeniedPage("/403")
			; 
		
		
		//http.csrf().disable();
		http.addFilterBefore(sbssFilterSecurityInterceptor, FilterSecurityInterceptor.class);
	}
}
