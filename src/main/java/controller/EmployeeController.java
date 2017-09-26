package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    //访问路径是/employee/list.html
    @RequestMapping("/list.html")
    public String list() {
        //省略查询员工列表的代码
        return "/emp_list.jsp";
    }
    //访问路径是/employee/update.html
    @RequestMapping("/update.html")
    public String update(Employee emp) {
        //省略修改员工代码
        return "/emp_list.jsp";
    }
}
