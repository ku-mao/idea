import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//服务器给浏览器写cookie
public class ServletDemo7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先构造cookie 对象, 每个cookie 对象就是一个键值对
        Cookie userName = new Cookie("username", "drr");
        Cookie password = new Cookie("password", "123456");
        // 把cookie 放入到响应中
        resp.addCookie(userName);
        resp.addCookie(password);
        //创建一个响应报文
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write("返回 cookie 成功");
    }
}

