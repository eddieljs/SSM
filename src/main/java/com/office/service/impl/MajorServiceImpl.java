package com.office.service.impl;

import com.office.bean.Major;
import com.office.mapper.MajorMapper;
import com.office.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    MajorMapper majorMapper;

    @Override
    public long findTotalcount(){
        return majorMapper.findTotalcount();
    }

    @Override
    public List<Major> findMajorsByPage(Map<String,Object> map){
        return majorMapper.findMajorsByPage(map);
    }

    @Override
    public boolean deleteById(int id){
        return majorMapper.deleteById(id);
    }

    @Override
    public Major findById(int id) {
        return majorMapper.findById(id);
    }

    @Override
    public int updateMajor(Major major){
        return majorMapper.updateMajor(major);
    }

    @Override
    public int addMajor(Major major){
        return majorMapper.addMajor(major);
    }

}
