package cn.hzy.demo.config;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("hzy","123");
    }

    @Bean
    public feign.Logger.Level getLoggerLevel(){
        return Logger.Level.FULL;
    }
}
