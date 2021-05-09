package cn.hzy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages={"cn.hzy.demo.dao"})
public class ServiceSwagger
{
    public static void main( String[] args )
    {
        SpringApplication.run(ServiceSwagger.class,args);
    }
}
