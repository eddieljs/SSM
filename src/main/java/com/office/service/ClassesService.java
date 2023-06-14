package com.office.service;

import com.office.bean.Classes;

import java.util.List;
import java.util.Map;

public interface ClassesService {
    long findTotalcount();
    List<Classes> findClassesByPage(Map<String,Object> map);
    long findStudentCount(long classId);
}
