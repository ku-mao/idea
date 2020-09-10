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

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        UserDao userDao = new UserDao();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Map<String, Object> returnMap = new HashMap<>();
        if (null == username || "".equals(username) || null == password || "".equals(password)) {
            returnMap.put("msg", false);
        } else if (userDao.findByName(username)){
                returnMap.put("msg", false);
            }else {
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                userDao.addUser(user);
                returnMap.put("msg", true);
            }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), returnMap);
    }
}
