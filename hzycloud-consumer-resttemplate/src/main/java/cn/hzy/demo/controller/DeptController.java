package cn.hzy.demo.controller;

import cn.hzy.demo.to.DeptDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController {

    private static final String DETP_ADD_URL = "http://localhost:8001/dept/add";
    private static final String DETP_GET_URL = "http://localhost:8001/dept/get";
    private static final String DETP_LIST_URL = "http://localhost:8001/dept/list";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HttpHeaders httpHeaders;


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
}
