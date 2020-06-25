package com.jagadeesh.orderservice.feign.config;

import feign.Contract;
import feign.auth.BasicAuthRequestInterceptor;
import feign.okhttp.OkHttpClient;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;

public class CustomFeignConfig {

    @Bean
    public Contract feignContract() {
        return new SpringMvcContract();
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password");
    }

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

}
