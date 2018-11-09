package com.sb_ss_myb.frame.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisScannerConfig {
	
	@Bean
	public MapperScannerConfigurer mapperScannerConfigure() {
		
		MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
		scannerConfigurer.setBasePackage("com.sb_ss_myb.frame.dao");
		scannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		
		return scannerConfigurer;
	}

}
