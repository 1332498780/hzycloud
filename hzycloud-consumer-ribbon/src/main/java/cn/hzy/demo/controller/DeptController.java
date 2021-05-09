package cn.hzy.demo.controller;

import cn.hzy.demo.to.DeptDto;
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

    private static final String DETP_ADD_URL = "http://hzycloud-dept-service/dept/add";
    private static final String DETP_GET_URL = "http://hzycloud-dept-service/dept/get";
    private static final String DETP_LIST_URL = "http://hzycloud-dept-service/dept/list";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HttpHeaders httpHeaders;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @PostMapping("/consumer/dept/add")
    public DeptDto add(DeptDto deptDto){
        return restTemplate.exchange(DETP_ADD_URL, HttpMethod.POST,new HttpEntity<Object>(httpHeaders),DeptDto.class).getBody();
    }

    @GetMapping("/consumer/dept/get/{id}")
    public DeptDto get(@PathVariable Integer id){
        return restTemplate.exchange(DETP_GET_URL+"/"+id, HttpMethod.GET,new HttpEntity<Object>(httpHeaders),DeptDto.class).getBody();
    }

    @GetMapping("/consumer/dept/list")
    public List<DeptDto> list(){
        return restTemplate.exchange(DETP_LIST_URL,HttpMethod.GET,new HttpEntity<Object>(httpHeaders),List.class).getBody();
    }

    @GetMapping("/ribbon/client")
    public Object client(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("hzycloud-dept-service");
        Map<String,Object> info = new HashMap<>();
        info.put("host",serviceInstance.getHost());
        info.put("port",serviceInstance.getPort());
        return info;
    }
}
