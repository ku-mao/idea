package api;

import model.Dao.UserDao;
import model.User;
import view.HtmlGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        //1.获取到用户的用户名和密码, 判断是否在合法范围中
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (null == name || "".equals(name)||
            null == password || "".equals(password))  {
            String html = HtmlGenerator.getMessage("用户名或者密码为空", "login.html");
            resp.getWriter().write(html);
            return;
        }
        //2.看用户是否存在
        UserDao userDao = new UserDao();
        User user = userDao.selectByName(name);
        if (user == null || !password.equals(user.getPassword())) {
            String html = HtmlGenerator.getMessage("用户名或者密码错误", "login.html");
            resp.getWriter().write(html);
            return;
        }
        //3.匹配成功认为登录成功, 创建session对象
        HttpSession session = req.getSession(true);
        session.setAttribute("user", user);

        //4.返回登录成功页面, 跳转到文章页面
        String html = HtmlGenerator.getMessage("登录成功", "article");
        resp.getWriter().write(html);
    }

}
