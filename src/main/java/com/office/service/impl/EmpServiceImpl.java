package com.office.service.impl;


import com.office.bean.Emp;
import com.office.mapper.EmpMapper;
import com.office.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;
    @Override
    public Emp login(Emp emp){
        return empMapper.login(emp);
}
    @Override
    public long findTotalcount(){
        return empMapper.findTotalcount();
    }
    @Override
    public List<Emp> findEmpsByPage(Map<String,Object> map){
        return empMapper.findEmpsByPage(map);
    }
    @Override
    public int addEmp(Emp emp){
        return empMapper.addEmp(emp);
    }
}
