package cn.hzy.demo.service;

import cn.hzy.demo.to.DeptDto;

import java.util.List;

public interface IDeptService {

    public DeptDto add(DeptDto deptDto);
    public DeptDto get(int id);
    public List<DeptDto> list();
}
