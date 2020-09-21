package com.lob.springboot_api.config;

import com.lob.springboot_api.Interceptor.LoginCheckInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class SessionConfig extends WebMvcConfigurerAdapter {

    private final LoginCheckInterceptor loginCheckInterceptor;

    public SessionConfig(LoginCheckInterceptor loginCheckInterceptor) {
        this.loginCheckInterceptor = loginCheckInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor)
                .addPathPatterns("/api/users/**"); //users/.. 모든 URI 매칭

    }

}
