package com.office.mapper;

import com.office.bean.Major;

import java.util.List;
import java.util.Map;

public interface MajorMapper {
    long findTotalcount();
    List<Major> findMajorsByPage(Map<String,Object> map);

    boolean deleteById(int id);

    Major findById(int id);
    int updateMajor(Major major);

    int addMajor(Major major);
}
