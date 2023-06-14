package com.office.mapper;

import com.office.bean.Depart;

import java.util.List;
import java.util.Map;

public interface DepartMapper {
    //部门新增
    int addDepart(Depart depart);
    //查询记录的总条数
    long findTotalcount();
    //查询每页数据
    List<Depart> findDepartByPage(Map<String,Object> map);
    //部门删除
    boolean deleteById(int id);
    //根据id获取部门信息
    Depart findById(int id);
    //更新部门
    int updateDepart(Depart depart);
    //统计每个部门的人数
    long findEmpCountByDepartId(long did);
    //下拉框绑定
    List<Depart> findDeparts();
}
