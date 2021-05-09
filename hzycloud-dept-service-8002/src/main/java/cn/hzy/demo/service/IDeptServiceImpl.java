package cn.hzy.demo.service;

import cn.hzy.demo.dao.DeptRepository;
import cn.hzy.demo.entity.Dept;
import cn.hzy.demo.to.DeptDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IDeptServiceImpl implements IDeptService{

    @Autowired
    private DeptRepository deptDao;

    @Override
    public DeptDto add(DeptDto deptDto) {
        Dept dept = new Dept();
        BeanUtils.copyProperties(deptDto,dept);
        DeptDto returnDept = new DeptDto();
        BeanUtils.copyProperties(deptDao.save(dept),returnDept);
        return returnDept;
    }

    @Override
    public DeptDto get(int id) {
        Dept dept = deptDao.findOne(id);
        DeptDto returnDept = new DeptDto();
        BeanUtils.copyProperties(dept,returnDept);
        return returnDept;
    }

    @Override
    public List<DeptDto> list() {
        List<Dept> list = deptDao.findAll();
        List<DeptDto> returnList = new ArrayList<>();
        for(Dept dept:list){
            DeptDto returnDept = new DeptDto();
            BeanUtils.copyProperties(dept,returnDept);
            returnList.add(returnDept);
        }
        return returnList;
    }
}
