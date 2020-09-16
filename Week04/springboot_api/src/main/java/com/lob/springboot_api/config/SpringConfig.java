package com.lob.springboot_api.config;

import com.lob.springboot_api.Repository.RequestApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
public class SpringConfig extends WebMvcConfigurerAdapter {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource, LoginCheckInterceptor loginCheckInterceptor) {
        this.dataSource = dataSource;
        this.loginCheckInterceptor = loginCheckInterceptor;
    }

    @Bean
    public RequestApiRepository requestApiRepository() {
        return new RequestApiRepository(dataSource);
    }

    private final LoginCheckInterceptor loginCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor)
                .addPathPatterns("/api/users/**"); //users/.. 모든 URI 매칭

    }


}
