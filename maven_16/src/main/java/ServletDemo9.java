import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.Writer;

//写一个页面, 记录用户访问页面的次数
public class ServletDemo9 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.先获取Session.
        // 如果用户曾经没有访问过，此时将创建新的session
        // 如果用户已经访问过了，就获取到曾经的Session
        //新用户访问:
        // 这个操作就会自动生成一个sessionId,同时创建个httpSession对象
        // 把这个键值对放到内置的hash 表中，同时把sessionId 写回到浏览器的Cookie中
        //老用户访问:
        // 根据请求中Cookie 里的sessionId, 在hash 表中查，找到对应的session对象
        HttpSession httpSession = req.getSession();
        Integer count = 1;
        if (httpSession.isNew()) {
            //把count 值写入到session 对象中
            httpSession.setAttribute("count", count);
        } else {
            count = (Integer) httpSession.getAttribute("count");
            httpSession.setAttribute("count", count + 1);
        }
        //返回响应页面
        resp.setContentType("text/html; charset=utf-8");
        Writer writer = resp.getWriter();
        writer.write("<html>");
        writer.write("count: " + count);
        writer.write("</html>");
    }
}
