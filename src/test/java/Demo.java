import com.office.bean.Emp;
import com.office.bean.Loginlog;
import com.office.service.ClassesService;
import com.office.service.EmpService;
import com.office.service.LoginlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {
    @Autowired
    EmpService empService;
    @Autowired
    LoginlogService loginlogService;
    @Autowired
    ClassesService classesService;
    @Test
    public void loginTest(){
        Emp emp=new Emp();
        emp.setNo("1234");
        emp.setPass("admin");
        Emp loginUser=empService.login(emp);
        System.out.println(loginUser);
    }

    @Test
    public void findtotal(){
        long studentCount = classesService.findStudentCount(1);
        System.out.println(studentCount);
    }

}
