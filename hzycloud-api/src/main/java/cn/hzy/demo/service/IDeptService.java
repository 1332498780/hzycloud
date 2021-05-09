package cn.hzy.demo.service;

import cn.hzy.demo.config.FeignConfig;
import cn.hzy.demo.to.DeptDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "hzycloud-dept-service",configuration = FeignConfig.class)
public interface IDeptService {

    @PostMapping("/dept/add")
    public DeptDto add(DeptDto deptDto);

    @GetMapping("/dept/get/{id}")
    public DeptDto get(@PathVariable("id") int id);

    @GetMapping("dept/list")
    public List<DeptDto> list();
}
