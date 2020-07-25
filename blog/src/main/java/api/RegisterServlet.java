package api;

import model.Dao.UserDao;
import model.User;
import view.HtmlGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        //1.获取到前端页面的用户名和密码,校验是否合法
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (null == name || "".equals(name) || null == password || "".equals(password)) {
            //如果不合法,返回一个提示页面,告诉用户输入的用户名或者密码为空
            //这里的提示页面采用拼字符串的形式
            String html = HtmlGenerator.getMessage("输入的用户名或者密码为空!", "register.html");
            resp.getWriter().write(html);
            return;
        }
        //2.判断用户名是否存在,存在返回一个提示页面,告诉用户,用户名重复
        UserDao userDao = new UserDao();
        User exitUser = userDao.selectByName(name);
        if (exitUser != null) {
            String html = HtmlGenerator.getMessage("用户名重复", "register.html");
            resp.getWriter().write(html);
            return;
        }
        //3.根据提交的用户名和密码, 构造一个User, 存到数据库
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userDao.add(user);
        //4.返回一个注册成功的页面
        String html = HtmlGenerator.getMessage("注册成功!", "login.html");
        resp.getWriter().write(html);
    }
}
