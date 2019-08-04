package com.home.dz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.home.dz.repository.PricerRepository;
import com.home.dz.repository.PricerRepositoryImpl;
import com.home.dz.service.PricerService;
import com.home.dz.service.PricerServiceImpl;

@Configuration
@ComponentScan(basePackages = { "com.home.dz.service","com.home.dz.repository" })
public class ServiceConfig  {
    

	 

}