package com.home.dz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.home.dz.service", "com.home.dz.repository" })
public class ServiceConfig {

}