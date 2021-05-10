package cn.hzy.demo.service;

import cn.hzy.demo.to.DeptDto;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IDeptServiceFallBack implements FallbackFactory<IDeptService> {

    @Override
    public IDeptService create(Throwable throwable) {
        return new IDeptService() {
            @Override
            public DeptDto add(DeptDto deptDto) {
                DeptDto returnDeptDto = new DeptDto();
                returnDeptDto.setDeptNo(-1);
                returnDeptDto.setdName("失败回退");
                returnDeptDto.setLoc("失败回退");
                return returnDeptDto;
            }

            @Override
            public DeptDto get(int id) {
                DeptDto returnDeptDto = new DeptDto();
                returnDeptDto.setDeptNo(-100);
                returnDeptDto.setdName("失败回退");
                returnDeptDto.setLoc("失败回退");
                return returnDeptDto;
            }

            @Override
            public List<DeptDto> list() {
                List<DeptDto> list = new ArrayList<>();
                DeptDto returnDeptDto = new DeptDto();
                returnDeptDto.setDeptNo(-1);
                returnDeptDto.setdName("失败回退");
                returnDeptDto.setLoc("失败回退");
                list.add(returnDeptDto);
                return list;
            }
        };
    }
}
