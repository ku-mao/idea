package servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Map<String, Object> returnMap = new HashMap <>();
        UserDao userDao = new UserDao();
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        User user = userDao.login(username);
        if (user != null && user.getPassword().equals(password)) {
            req.getSession().setAttribute("user", user);
            returnMap.put("msg", true);
            System.out.println("登录成功");
        } else {
            returnMap.put("msg", false);
            System.out.println("账户或者密码错误");
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), returnMap);
    }
}
