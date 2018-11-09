package com.sb_ss_myb.frame.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MyBatisConfig {
	
	@Autowired
	private DataSource dataSource;
	
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean sqlSessionFactory(ApplicationContext applicationContext) throws IOException {
		
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setMapperLocations(applicationContext.getResources("classpath*:mapper/*.xml"));
		
		return factoryBean;
	}

}
