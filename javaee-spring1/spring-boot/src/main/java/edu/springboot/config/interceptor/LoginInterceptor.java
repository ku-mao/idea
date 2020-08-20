package edu.springboot.config.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.springboot.model.ResponseResult;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;


/**
 * 定义拦截器:
 * 只有配置的拦截器路径匹配请求路径时, 才会执行拦截器中的方法
 */
public class LoginInterceptor implements HandlerInterceptor {

    private ObjectMapper objectMapper;
    public LoginInterceptor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    //controller 中请求的方法执行前, 就会调用preHandle方法,
    // 返回值决定是否在继续执行controller中的方法
    //true 继续执行 false 表示不执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            return true;
        }
        ResponseResult result = new ResponseResult();
        result.setCode("ERR401");
        result.setMessage("用户未登录, 不能访问");
        String json = objectMapper.writeValueAsString(result);//把java对象序列化为json字符串
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(json);
        writer.flush();
        return false;
    }

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
}
