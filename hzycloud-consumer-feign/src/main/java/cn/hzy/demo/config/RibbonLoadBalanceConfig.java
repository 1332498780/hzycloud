package cn.hzy.demo.config;


import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;

public class RibbonLoadBalanceConfig {

    @Bean
    public IRule getIRule(){
        return new RandomRule();
    }

    @Bean
    public IPing getIPing(){
        return new PingUrl();
    }
}
