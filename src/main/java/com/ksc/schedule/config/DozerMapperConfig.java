package com.ksc.schedule.config;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.ksc.schedule.mapper.DozerMapper;
import com.ksc.schedule.mapper.DozerMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerMapperConfig {

    @Bean
    public Mapper dozerMapper() {
        return DozerBeanMapperBuilder.create()
            .withMappingFiles("dozer-mappings.xml")
            .build();
    }

    @Bean
    public DozerMapper objectMapper() {
        return new DozerMapperImpl(dozerMapper());
    }

}
