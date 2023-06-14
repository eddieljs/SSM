package com.office.web;

import com.alibaba.druid.sql.PagerUtils;
import com.office.bean.Depart;
import com.office.service.DepartService;
import com.office.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DepartController {
    @Autowired
    DepartService departService;
    @RequestMapping("/depart_add")
    public void addDepart(Depart depart, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        System.out.println(depart);
        int i=departService.addDepart(depart);
        if (i>0){//成功
            response.getWriter().write("<script>alert('新增成功！');location.href='html_departlist';</script>");
        }else{
            response.getWriter().write("<script>alert('新增失败！');location.href='html_departadd';</script>");
        }
    }

    @RequestMapping("/depart_list")
    public String list(long pageIndex,long pageSize,Model model){
        //总条数
        long totalcount=departService.findTotalcount();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("pageStart",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        //每页的数据
        List<Depart> departs=departService.findDepartByPage(map);
        for (Depart depart:departs){
            long empCount=departService.findEmpCountByDepartId(depart.getId());
            depart.setEmpCount(empCount);
        }
        //分页数据封装工具类
        PageUtils<Depart> pageUtils=new PageUtils<Depart>(pageIndex,pageSize,totalcount,departs);
        model.addAttribute("pageUtils",pageUtils);
        return "departlist";
    }

    @RequestMapping("/depart_delete")
    @ResponseBody
    public boolean depart_delete(int id){
        return departService.deleteById(id);
    }

    @RequestMapping("/depart_toupdate/{id}")
    public String depart_toupdate(@PathVariable("id") int id,Model model){
       Depart depart=departService.findById(id);
       model.addAttribute("depart",depart);
       return "departupdate";
    }

    //部门更新
    @RequestMapping("/depart_update")
    public void update(Depart depart,HttpServletResponse response) throws Exception{
        //设置浏览器的响应内容
        response.setContentType("text/html;charset=utf-8");
        int count=departService.updateDepart(depart);
        if (count>0){
            response.getWriter().write("<script>alert('更新部门成功');location.href='depart_list?pageIndex=1&pageSize=5';</script>");
        }else{
            response.getWriter().write("<script>alert('更新部门失败');location.href='depart_toupdate/"+depart.getId()+"';</script>");
        }
    }

}
