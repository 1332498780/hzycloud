package cn.hzy.demo.rest;

import cn.hzy.demo.service.IDeptService;
import cn.hzy.demo.service.IDeptServiceImpl;
import cn.hzy.demo.to.DeptDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptRest {

    @Autowired
    private IDeptService deptService;

    @ApiOperation(value = "增加部门",notes = "需要传入dto对象，dname,loc")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deptDto",value = "部门实体",required = true,dataType = "DeptDto")
    })
    @PostMapping("/add")
    public String add(@RequestBody DeptDto deptDto){
        deptService.add(deptDto);
        return "add";
    }

    @ApiOperation(value = "根据id查找部门",notes = "需要传入id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "部门编号",required = true,dataType = "Integer",paramType = "path")
    })
    @GetMapping("/get/{id}")
    public DeptDto get(@PathVariable Integer id){
        return deptService.get(id);
    }

    @ApiOperation(value = "部门列表",notes = "")
    @GetMapping("/list")
    public List<DeptDto> list(){
        return deptService.list();
    }
}
