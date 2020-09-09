package com.lob.springboot_api.config;

import com.lob.springboot_api.Repository.RequestApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Bean
    public RequestApiRepository requestApiRepository() {
        return new RequestApiRepository(dataSource);
    }

}
