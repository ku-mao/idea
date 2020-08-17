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
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    Gson gson = new GsonBuilder().create();
    static class Request {
        public String name;
        public String password;
    }
    static class Response {
        public int ok;
        public String reason;
        public String name;
        public int isAdmin;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Response response = new Response();
        req.setCharacterEncoding("utf-8");
        try {
            //1.解析body内容
            String body = new GetBodyUtil().getBody(req);
            //2.把body转换为json对象
            Request request = gson.fromJson(body, Request.class);
            //3.查看是否在数据库中, 并校验密码是否正确
            UserDao userDao = new UserDao();
            User user = userDao.selectByName(request.name);
            if (user == null || !user.getPassword().equals(request.password)) {
                throw new OrderSystemException("用户名不存在或者密码错误!");
            }
            //4.正确就创建session对象, 错误就返回错误信息
            HttpSession session = req.getSession(true);
            session.setAttribute("user", user);
            //5.构造json对象
            response.ok = 1;
            response.reason = "";
            response.name = user.getName();
            response.isAdmin = user.getIsAdmin();
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            //6.返回响应
            String jsonString = gson.toJson(response);
            resp.setContentType("application/json; charset=utf-8");
            resp.getWriter().write(jsonString);
        }
    }

    //检查登录状态
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response response = new Response();
        try {
            //1.获取session, 判断是否登录
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("当前未登录, 请先登录");
            }
            //2.从session中取到对象, 判断是否登录
            User user = (User) session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("当前未登录, 请先登录");
            }
            //3.构造json对象
            response.ok = 1;
            response.reason = "";
            response.name = user.getName();
            response.isAdmin = user.getIsAdmin();
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            //4.返回结果
            resp.setContentType("application/json; charset=utf-8");
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }
}
