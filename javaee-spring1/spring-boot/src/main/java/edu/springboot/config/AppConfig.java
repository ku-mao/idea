package edu.springboot.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.springboot.config.interceptor.LoginInterceptor;
import edu.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig implements WebMvcConfigurer { //web 做初始化工作的时候,会调用接口方法

    @Autowired
    private ObjectMapper objectMapper;
    /**
     *   /* 表示模糊匹配拦截
     *
     *   添加web配置: 添加拦截器(根据路径进行拦截)
     *    /* : 代表一级的路径, 如/user/*, 可以匹配到/user/a  但是不可以匹配到/user/a/b
     *    /** "代表匹配多级路径
     *    静态资源也会被拦截
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //实现用户会话管理的功能
        registry.addInterceptor(new LoginInterceptor(objectMapper))
                .addPathPatterns("/user/**") //添加要拦截的路径
                .excludePathPatterns("/user/login"); //排除的路径
    }

    @Bean
    public Map<String, String> test1() {
        Map<String, String> map = new HashMap <>();
        map.put("d", "荣荣");
        map.put("h", "敏");
        return map;
    }

    @Bean
    public User user1() {
        User user = new User();
        user.setName("drr");
        user.setPassword("123");
        return user;
    }

    @Bean
    public User user2() {
        User user = new User();
        user.setName("hm");
        user.setPassword("123");
        return user;
    }
}
