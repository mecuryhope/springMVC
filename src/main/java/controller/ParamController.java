package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.Dept;
import pojo.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ParamController {
    //
    @RequestMapping("param1.html")
    public String testParam1(@RequestParam(value = "name") String name,
                             @RequestParam(value = "id") Integer id) {

        System.out.println(name);
        System.out.println(id);
        return "index.jsp";
    }

    //参数不是必传时，使用required=false
    @RequestMapping("param2.html")
    public String testParam2(@RequestParam(value = "name", defaultValue = "123") String name,
                             @RequestParam(value = "id", required = false) Integer id) {
        System.out.println(name);
        System.out.println(id);
        return "index.jsp";
    }

    //当url中的参数名与方法接收时参数名一致，且参数都是必传的，可以省略@RequestParam
    @RequestMapping("param3.html")
    public String testParam3(String name, Integer id) {
        System.out.println(name);
        System.out.println(id);
        return "index.jsp";
    }

    //得到HttpServletRequest和HttpServletResponse
    @RequestMapping("param4.html")
    public String testParam4(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getParameter("name"));
        return "index.jsp";
    }

    //映射pojo类
    @RequestMapping("param5.html")
    public String testParam5(Employee employee) {
        System.out.println("员工名：" + employee.getName());
        System.out.println("员工id:" + employee.getId());
        //支持级联形式的映射
        System.out.println("员工部门名：" + employee.getDept().getName());
        System.out.println("员工部id：" + employee.getDept().getId());
        return "index.jsp";
    }

    //映射数组
    @RequestMapping("param6.html")
    public String testParam5(Integer[] ids) {
        for (Integer id : ids) {
            System.out.println(id);
        }
        return "index.jsp";
    }

    //List集合中包含基本数据类型
    @RequestMapping("param7.html")
    public String testParam7(@RequestBody List<String> names) {
        for (String name : names) {
            System.out.println(name);
        }
        return "index.jsp";
    }

    //List集合中包含对象类型
    @RequestMapping("param8.html")
    //如果是数组，就写(@RequestBody Dept[] depts)
    public String testParam8(@RequestBody List<Dept> depts) {
        //public String testParam8(@RequestBody Dept[] depts) {
        for (Dept dept : depts) {
            System.out.println(dept.getId() + dept.getName());
        }
        return "index.jsp";
    }

    //POJO中包含List。Dept中包含List<Employee>
    @RequestMapping("param9.html")
    public String testParam9(@RequestBody Dept dept) {
        System.out.println(dept.getName());
        for (Employee employee : dept.getEmployees()) {
            System.out.println(employee.getName());
        }
        return "index.jsp";
    }

    //List<Map<String,Object>>的映射
    @RequestMapping("param10.html")
    public String testParam10(@RequestBody List<Map<String, Object>> map) {
        for (Map<String, Object> stringObjectMap : map) {//遍历集合
            for (String key : stringObjectMap.keySet()) {//遍历当前Map中的key
                //根据key拿到对应的值
                System.out.println(key + "=" + stringObjectMap.get(key));
            }
            System.out.println("--------------------");
        }
        return "index.jsp";
    }

}
