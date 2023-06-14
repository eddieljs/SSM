package com.office.web;

import com.office.bean.Classes;
import com.office.service.ClassesService;
import com.office.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ClassesController {
    @Autowired
    ClassesService classesService;
    @RequestMapping("/classes_list")
    public String list(long pageIndex, long pageSize, Model model){
        //总条数
        long totalcount=classesService.findTotalcount();
        Map<String,Object> map=new HashMap<>();
        map.put("pageStart",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        //每页的数据
        List<Classes> classes=classesService.findClassesByPage(map);
        for(Classes c :classes){
            long studentCount=classesService.findStudentCount(c.getId());
            c.setStudentCount(studentCount);
        }
        //分页数据封装工具类
        PageUtils<Classes> pageUtils=new PageUtils<>(pageIndex,pageSize,totalcount,classes);
        model.addAttribute("pageUtils",pageUtils);
        //列表页面
        return "classeslist";
    }
}
