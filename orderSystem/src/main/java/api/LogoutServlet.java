package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import util.OrderSystemException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 注销
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    Gson gson = new GsonBuilder().create();
    static class Response {
        public int ok;
        public String reason;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response response = new Response();
        try {
            //1.获取到session对象
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("当前未登录");
            }
            //2.把对象从session中删除
            session.removeAttribute("user");
            //3.构造json对象
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            //4.返回响应
            resp.setContentType("application/json; charset=utf-8");
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }
}
