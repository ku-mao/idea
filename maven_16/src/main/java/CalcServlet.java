import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String aValue = req.getParameter("a");
        String bValue = req.getParameter("b");
        int a = Integer.parseInt(aValue);
        int b = Integer.parseInt(bValue);
        int res = a + b;
        resp.getWriter().write(String.format("<h1>result = %s</h1>", res));
    }
}
