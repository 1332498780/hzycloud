package cn.hzy.demo.controller;

import cn.hzy.demo.service.IDeptService;
import cn.hzy.demo.service.IDeptServiceFallBack;
import cn.hzy.demo.to.DeptDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DeptController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private IDeptService iDeptService;

    @Autowired
    IDeptServiceFallBack fallBack;

    @PostMapping("/consumer/dept/add")
    public DeptDto add(DeptDto deptDto){
        return iDeptService.add(deptDto);
    }

//    @HystrixCommand(fallbackMethod = "fallBack")
    @GetMapping("/consumer/dept/get/{id}")
    public DeptDto get(@PathVariable Integer id){
        return iDeptService.get(id);
    }

    @GetMapping("/consumer/dept/list")
    public List<DeptDto> list(){
        return iDeptService.list();
    }

    @GetMapping("/ribbon/client")
    public Object client(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("hzycloud-dept-service");
        Map<String,Object> info = new HashMap<>();
        info.put("host",serviceInstance.getHost());
        info.put("port",serviceInstance.getPort());
        return info;
    }

    private DeptDto fallBack(Integer id){
        System.out.println(fallBack);
        DeptDto returnDeptDto = new DeptDto();
        returnDeptDto.setDeptNo(-1);
        returnDeptDto.setdName("失败回退");
        returnDeptDto.setLoc("失败回退");
        return returnDeptDto;
    }
}
