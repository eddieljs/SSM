package com.office.service.impl;

import com.office.bean.Depart;
import com.office.mapper.DepartMapper;
import com.office.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DepartServiceImpl implements DepartService {
    @Autowired
    DepartMapper departMapper;
    @Override
    public int addDepart(Depart depart){
        return departMapper.addDepart(depart);
    }

    @Override
    public long findTotalcount(){
        return departMapper.findTotalcount();
    }

    @Override
    public List<Depart> findDepartByPage(Map<String, Object> map) {
        return departMapper.findDepartByPage(map);
    }

    @Override
    public boolean deleteById(int id){
        return departMapper.deleteById(id);
    }

    @Override
    public Depart findById(int id){
        return departMapper.findById(id);
    }

    @Override
    public int updateDepart(Depart depart){
        return departMapper.updateDepart(depart);
    }

    @Override
    public long findEmpCountByDepartId(long did) {
        return departMapper.findEmpCountByDepartId(did);
    }

    @Override
    public List<Depart> findDeparts(){
        return departMapper.findDeparts();
    }
}
