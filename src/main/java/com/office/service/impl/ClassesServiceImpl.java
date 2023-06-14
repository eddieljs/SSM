package com.office.service.impl;

import com.office.bean.Classes;
import com.office.mapper.ClassesMapper;
import com.office.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    ClassesMapper classesMapper;

    @Override
    public long findTotalcount(){
        return classesMapper.findTotalcount();
    }

    @Override
    public List<Classes> findClassesByPage(Map<String,Object> map){
        return classesMapper.findClassesByPage(map);
    }

    @Override
    public long findStudentCount(long classId){
        return classesMapper.findStudentCount(classId);
    }
}
