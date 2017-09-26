package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Dept;

@Controller
@RequestMapping("/dept")
public class DeptController {
    //访问路径是/dept/list.html
    @RequestMapping("/list.html")
    public String list() {
        //省略查查询部门列表的代码
        return "/dept_list.jsp";
    }
    //访问路径是/dept/update.html
    @RequestMapping("/update.html")
    public String update(Dept dept) {
        //省略修改部门代码
        return "/dept_list.jsp";
    }
}
