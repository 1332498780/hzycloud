package cn.hzy.demo;

import cn.hzy.demo.config.RibbonLoadBalanceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "ribbonClient",configuration = RibbonLoadBalanceConfig.class)
public class RibbonApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(RibbonApplication.class,args);
    }
}
