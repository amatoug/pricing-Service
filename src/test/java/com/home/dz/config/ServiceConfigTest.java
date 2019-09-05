package com.home.dz.config;

import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@Import(ServiceConfig.class)
@ActiveProfiles("test")
public class ServiceConfigTest {

}