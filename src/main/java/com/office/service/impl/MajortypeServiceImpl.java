package com.office.service.impl;

import com.office.bean.Majortype;
import com.office.mapper.MajortypeMapper;
import com.office.service.MajortypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajortypeServiceImpl implements MajortypeService {
    @Autowired
    MajortypeMapper majortypeMapper;

    @Override
    public List<Majortype> findMajortypes(){
        return majortypeMapper.findMajortypes();
    }
}
