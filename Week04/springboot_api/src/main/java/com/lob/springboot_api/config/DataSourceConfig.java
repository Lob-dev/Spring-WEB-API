package com.lob.springboot_api.config;

import com.lob.springboot_api.Interceptor.LoginCheckInterceptor;
import com.lob.springboot_api.Repository.RequestApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    private DataSource dataSource;

    @Autowired
    public DataSourceConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public RequestApiRepository requestApiRepository() {
        return new RequestApiRepository(dataSource);
    }

}
