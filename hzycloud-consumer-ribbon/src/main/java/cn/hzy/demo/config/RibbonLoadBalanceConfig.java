package cn.hzy.demo.config;


import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import org.springframework.context.annotation.Bean;

public class RibbonLoadBalanceConfig {

    @Bean
    public IRule getIRule(){
        return new ZoneAvoidanceRule();
    }

    @Bean
    public IPing getIPing(){
        return new PingUrl();
    }
}
