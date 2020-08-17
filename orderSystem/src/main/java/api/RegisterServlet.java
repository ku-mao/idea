package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.User;
import model.UserDao;
import util.GetBodyUtil;
import util.OrderSystemException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注册
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    //读取body 构造json对象
    Gson gson = new GsonBuilder().create();
    //json 的请求对象
    static class Request {
        public String name;
        public String password;
    }
    //json的响应对象
    static class Response {
        public int ok;
        public String reason;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("utf-8");
        Response response = new Response();
        try {
            //1.读取body的内容
            String body = new GetBodyUtil().getBody(req);
            //2.把body解析成request对象
            Request request = gson.fromJson(body, Request.class);
            //3.查看request对象是否在数据库中
            UserDao userDao = new UserDao();
            User exitUser = userDao.selectByName(request.name);
            if (exitUser != null) {
                //说明用户存在
                throw new OrderSystemException("用户名已存在");
            }
            //4.把提交的数据插入到数据库中
            User user = new User();
            user.setName(request.name);
            user.setPassword(request.password);
            user.setIsAdmin(0);
            userDao.add(user);
            //5.构造json对象
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            //6.返回响应数据
            String jsonString = gson.toJson(response);
            resp.setContentType("application/json; charset=utf-8");
            resp.getWriter().write(jsonString);
        }
    }


















}
