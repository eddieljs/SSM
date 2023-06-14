package com.office.mapper;

import com.office.bean.Classes;

import java.util.List;
import java.util.Map;

public interface ClassesMapper {
    long findTotalcount();
    List<Classes> findClassesByPage(Map<String,Object> map);
    long findStudentCount(long classId);
}
