package cn.hzy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages={"cn.hzy.demo.dao"})
@EnableEurekaClient
@EnableDiscoveryClient
public class Service8003
{
    public static void main( String[] args )
    {
        SpringApplication.run(Service8003.class,args);
    }
}
