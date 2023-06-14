package com.office.web;

import com.office.bean.Depart;
import com.office.bean.Major;
import com.office.bean.Majortype;
import com.office.service.MajorService;
import com.office.service.MajortypeService;
import com.office.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MajorController {
    @Autowired
    MajorService majorService;

    //分页
    @RequestMapping("/major_list")
    public String list(long pageIndex, long pageSize, Model model){
        //总条数
        long totalcount=majorService.findTotalcount();
        Map<String,Object> map=new HashMap<>();
        map.put("pageStart",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        //每页的数据
        List<Major> majors=majorService.findMajorsByPage(map);
        //分页数据封装工具类
        PageUtils<Major> pageUtils=new PageUtils<>(pageIndex,pageSize,totalcount,majors);
        model.addAttribute("pageUtils",pageUtils);
        //列表页面
        return "majorlist";
    }

    @RequestMapping("/major_delete/{id}")
    @ResponseBody
    public boolean detele(@PathVariable("id") int id){
        return majorService.deleteById(id);
    }

    @Autowired
    MajortypeService majortypeService;

    @RequestMapping("/major_findMajortypes")
    @ResponseBody
    public List<Majortype> findMajortypes(){
        return majortypeService.findMajortypes();
    }

    //跳转更新
    @RequestMapping("/major_toupdate/{id}")
    public String major_toupdate(@PathVariable("id") int id,Model model){
        Major major=majorService.findById(id);
        model.addAttribute("major",major);
        List<Majortype> majortypes=majortypeService.findMajortypes();
        model.addAttribute("majortypes",majortypes);
        return "majorUpdate";
    }

    //更新专业
    @RequestMapping("/major_update")
    public void major_update(Major major,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        int count=majorService.updateMajor(major);
        if (count>0){
            response.getWriter().write("<script>alert('更新专业成功');location.href='major_list?pageIndex=1&pageSize=5';</script>");
        }else{
            response.getWriter().write("<script>alert('更新专业失败');location.href='major_toupdate/"+major.getId()+"';</script>");
        }
    }

    //跳转到新增专业页面
    @RequestMapping("/major_toadd")
    public String major_toadd(Model model){
        List<Majortype> majortypes=majortypeService.findMajortypes();
        model.addAttribute("majortypes",majortypes);
        return "majoradd";
    }

    //新增专业
    @RequestMapping("/major_add")
    public void major_add(Major major,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        int count=majorService.addMajor(major);
        if (count>0){
            response.getWriter().write("<script>alert('新增专业成功');location.href='major_list?pageIndex=1&pageSize=5';</script>");
        }else{
            response.getWriter().write("<script>alert('新增专业失败');location.href='/html_majoradd';</script>");
        }
    }
}
