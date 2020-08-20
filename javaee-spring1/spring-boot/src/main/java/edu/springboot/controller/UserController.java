package edu.springboot.controller;

import edu.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private Map<String, String> test1;

//    @Qualifier("user1")
//    @Autowired
//    private User user;  自己想要起别名的话加@Qualifier("user1")

//    @Resource
//    private User user2;

//    @Resource(name = "user1")
//    private User user;

    @ResponseBody
    @RequestMapping("/login")
    public Object login(User user, HttpServletRequest request){

        if (!("dai".equals(user.getName()))) {
            throw new RuntimeException("用户登录失败");
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
        return user;
    }


    @RequestMapping("/main")
    public String main() {
        return "/main.html";
    }
    @RequestMapping("/d1")
    public String d1() {
        return "forward:login";
    }
    @RequestMapping("/d2")
    public String d2() {
        return "redirect:login";
    }

    @RequestMapping("/test/{key}")
    @ResponseBody
    public Object test1(@PathVariable("key") String s) {
        System.out.println("**********" + test1.get(s));
        return test1;
    }


    //请求get  /user/test2?k1=v1&k2=v2&k3=v3
    @ResponseBody
    @RequestMapping(value = "test2", method = {RequestMethod.GET, RequestMethod.POST })
    //可以匹配url中的参数,
    // 请求的数据格式from-data 和 x-www-from-urlencoded 时, 可以获取到请求体中的数据
    public Object test2(@RequestParam("k1") String key,//完整的写法, 通过注解值为key查找请求数据
                       @RequestParam String k2, //省略注解值, 默认以变量名为key查找请求数据
                       String k3 //最简单的写法, 默认加上@RequestParam注解
                       ) {
        System.out.println("**********" + key + " " + k2 + " " + k3);
        return test1;
    }

    @RequestMapping("/test3")
    @ResponseBody
    public Object test3(User user) {
        System.out.println("*********" + user);//请求数据自动映射到参数类型的属性中, name=xxx&password=xxx
        return test1;
    }

    @RequestMapping("/test4")
    @ResponseBody
    public Object test4() {
        return null; //响应体是空
    }

    @RequestMapping("/test5")
    @ResponseBody
    public Object test5() {
        return "ha"; //响应的格式不是application/json 而是text/plain(文本)
    }

    @RequestMapping("/test6")
    @ResponseBody
    //http 请求是基于Servlet的, spring已经生成了request 和 response 对象, 直接在参数中使用
    public Object test6(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("********" + req.getParameter("id") + " " + req.getParameter("name"));
        return null;
    }

    @RequestMapping("/test7")
    @ResponseBody
    //http 请求是基于Servlet的, spring已经生成了request 和 response 对象, 直接在参数中使用
    public Object test7(@RequestBody  User user) {//当请求的数据是json格式的时候, 解析请求体中的json字符串是java对象
        System.out.println("********" + user);
        return null;
    }

    /**
     * web开发经常的需求
     * 1.统一处理异常
     * 2.统一返回数据格式
     * 3.统一管理会话(登录的敏感信息资源权限控制)
     */

    @RequestMapping("/test8")
    @ResponseBody
    public Object test8() {
        throw  new RuntimeException("出现异常");
    }
}
