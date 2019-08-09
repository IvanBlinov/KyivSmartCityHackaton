package com.ksc.schedule.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(value = "com.ksc.schedule.repository")
public class JpaConfig {

}

