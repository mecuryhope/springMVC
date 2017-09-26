package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    //RequestMapping设置访问路径是index.html
    @RequestMapping(value = "/index.html")
    public String showIndex() {
        //返回index.jsp页面
        return "/index.jsp";
    }

    //此方法只支持POST访问方式
    @RequestMapping(value = "/post.html", method = RequestMethod.POST)
    public String showPost() {
        return "/index.jsp";
    }

    @RequestMapping(value = "xx.html", consumes = "application/json", params = {"p1=v1,"})
    public String testOtherParam() {
        return "/index.jsp";
    }

    //url中包含参数
    @RequestMapping("/rest1/{id}.html")
    public String testRest1(@PathVariable Integer id) {
        System.out.println(id);
        return "/index.jsp";
    }

    //占位的参数和方法中参数名不同的时候
    @RequestMapping("/rest2/{id}.html")
    public String testRest2(@PathVariable("id") Integer someId) {
        System.out.println(someId);
        return "/index.jsp";
    }

    //支持正则表达式匹配
    @RequestMapping("/reg/{param:[\\d]+}.html")
    public String testRest3(@PathVariable Integer param) {
        System.out.println(param);
        return "/index.jsp";
    }

    @RequestMapping("/ant/test??.html")
    public String testAnt() {
        return "/index.jsp";
    }
}
