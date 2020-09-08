package servlet;

import dao.MusicDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 上传到数据库
 */
@WebServlet("/uploadsucess")
public class UploadInsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");

        String singer = req.getParameter("singer");

        String fileName = (String) req.getSession().getAttribute("fileName");
        String[] str = fileName.split("\\.");
        String title = str[0];

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //2020-09-06
        String time = sdf.format(new Date());

        String url = "music/" + title;

        User user = (User) req.getSession().getAttribute("user");
        int userId = user.getId();

        MusicDao musicDao = new MusicDao();
        musicDao.add(title, singer, time, url, userId);
        resp.sendRedirect("list.html");

    }
}
