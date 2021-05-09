package cn.hzy.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Configuration
public class RestConfig {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public HttpHeaders getHttpHeaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        String auth = "hzy:123";
        try {
            byte[] encodeAuth = Base64.getEncoder().encode(auth.getBytes("US-ASCII"));
            String authHeader = "Basic "+new String(encodeAuth);
            httpHeaders.set("Authorization",authHeader);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return httpHeaders;
    }
}
