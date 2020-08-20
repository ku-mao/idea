package edu.springboot.config;

import edu.springboot.model.ResponseResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 指定身份: 拦截Controller中的web请求的类
 */
@ControllerAdvice
public class AppControllerAdvice implements ResponseBodyAdvice<Object> {

    @ExceptionHandler(Exception.class) //指定请求方法中抛出的异常
    @ResponseBody
    public Object handle(Exception e) {
        e.printStackTrace();//前端页面不报错, 状态码是200, 响应体为空, 数据在后端打印
        return null;
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class <? extends HttpMessageConverter<?>> aClass) {
        return true;//执行Controller 中的web请求方法结束, 返回数据到前端的时候, 是否要重写响应体
    }

    @Override
    public ResponseResult beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class <? extends HttpMessageConverter <?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        ResponseResult result = new ResponseResult();
        result.setSuccess(true);
        result.setData(body);
        return result;
    }
}
