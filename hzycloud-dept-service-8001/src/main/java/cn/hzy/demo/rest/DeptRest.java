package cn.hzy.demo.rest;

import cn.hzy.demo.service.IDeptService;
import cn.hzy.demo.service.IDeptServiceImpl;
import cn.hzy.demo.to.DeptDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptRest {

    @Autowired
    private IDeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/add")
    public String add(@RequestBody DeptDto deptDto){
        deptService.add(deptDto);
        return "add";
    }

    @GetMapping("/get/{id}")
    public DeptDto get(@PathVariable Integer id){
        return deptService.get(id);
    }

    @GetMapping("/list")
    public List<DeptDto> list(){
        return deptService.list();
    }

    @GetMapping("/dept/discover")
    public Object discover(){
        return discoveryClient;
    }

}
