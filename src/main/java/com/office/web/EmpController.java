package com.office.web;

import com.office.bean.*;
import com.office.service.DepartService;
import com.office.service.EmpService;
import com.office.service.LoginlogService;
import com.office.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class EmpController {
    @Autowired
    EmpService empService;
    @Autowired
    LoginlogService loginlogService;
    @Autowired
    DepartService departService;

    @RequestMapping({"/","login"})
    public String loginUI(){
        return "login";
    }

    @RequestMapping("/emp_login")
    public String login(Emp emp,String ip,String city, HttpSession session, HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("要登录的对象"+emp);
        Emp loginUser=empService.login(emp);
        String path=request.getContextPath();
        System.out.println("path"+path);
        if (loginUser!=null){//登录成功
            session.setAttribute("loginUser",loginUser);
            //将登录IP和城市等写入数据库
            Loginlog loginlog=new Loginlog(ip,emp.getNo(),city);
            loginlogService.addLog(loginlog);
            return "index";
        }else{//登录失败
            return "login";
        }

    }

    @RequestMapping("/emp_loginout")
    public String emp_loginout(HttpSession session){
        session.invalidate();
        return "login";
    }
    @RequestMapping("/main")
    public String mainUI(){
        return "main";
    }

    @RequestMapping("/emp_logs")
    @ResponseBody//返回值转JSON格式数据
    public List<Loginlog> emp_logs(HttpSession session){
        Emp emp=(Emp) session.getAttribute("loginUser");
        System.out.println(emp);
        System.out.println(loginlogService.findMyLogs(emp.getNo()));
        return loginlogService.findMyLogs(emp.getNo());
    }

    @RequestMapping("/emp_list")
    public String list(long pageIndex, long pageSize, Model model){
        //总条数
        long totalcount=empService.findTotalcount();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("pageStart",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Emp> emps=empService.findEmpsByPage(map);
        PageUtils<Emp> pageUtils= new PageUtils<Emp>(pageIndex,pageSize,totalcount,emps);
        model.addAttribute("pageUtils",pageUtils);
        return "emplist";
    }
    @RequestMapping("/emp_findDeparts")
    @ResponseBody
    public List<Depart> findDeparts(){
        return departService.findDeparts();
    }

    @RequestMapping("/emp_photoupload")
    @ResponseBody
    public MessageResult photoupload(MultipartFile file,HttpSession session) throws Exception{
        String filename= file.getOriginalFilename();
        System.out.println("上传文件的名字："+filename);
        String houzhui=filename.split("\\.")[1];
        String uuid= UUID.randomUUID().toString();
        String newFileName=uuid+"."+houzhui;
        System.out.println("服务器生成的新的文件名："+newFileName);
        //获取服务器上传的真实路径
        String realPath=session.getServletContext().getRealPath("/media/images")+"/"+newFileName;
        System.out.println("服务器上传路径是："+realPath);
        //开始上传
        file.transferTo(new File(realPath));
        System.out.println("文件上传完毕");
        MessageResult result=new MessageResult();
        result.setCode(1000);
        result.setMsg(newFileName);
        return result;
    }

    //新增
    @RequestMapping("/emp_add")
    public void add(Emp emp,HttpServletResponse response) throws Exception{
        //设置浏览器响应内容
        response.setContentType("text/html;charset=utf-8");
        int count=empService.addEmp(emp);
        if (count>0){
            response.getWriter().write("<script>alert('新增员工成功');location.href='emp_list?pageIndex=1&pageSize=5';</script>");
        }else{
            response.getWriter().write("<script>alert('新增员工失败');location.href='/html_empadd';</script>");
        }
    }
}
