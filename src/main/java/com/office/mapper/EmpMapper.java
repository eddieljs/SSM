package com.office.mapper;

import com.office.bean.Emp;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
    //用户登录
    Emp login(Emp emp);
    //查询总数
    long findTotalcount();
    List<Emp> findEmpsByPage(Map<String,Object> map);
    //新增
    int addEmp(Emp emp);
}
