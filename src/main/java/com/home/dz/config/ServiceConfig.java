package com.home.dz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.home.dz.service.PricerService;
import com.home.dz.service.PricerServiceImpl;

@Configuration
@ComponentScan(basePackages = { "com.home.dz.enums.service" })
public class ServiceConfig  {
    
	 @Bean(name="pricerService")
	    public PricerService pricerService()
	    {
	        return new PricerServiceImpl();
	    }
}