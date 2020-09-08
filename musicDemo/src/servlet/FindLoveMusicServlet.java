package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.MusicDao;
import entity.Music;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findLoveMusic")
public class FindLoveMusicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");

        User user = (User) req.getSession().getAttribute("user");
        MusicDao musicDao = new MusicDao();
        List<Music> loveMusicList = new ArrayList <>();
        String loveMusicName = req.getParameter("loveMusicName");
        if (loveMusicName != null) {
            loveMusicList = musicDao.findIfLoveMusic(loveMusicName, user.getId());
        } else {
            loveMusicList = musicDao.findAllLoveMusic(user.getId());
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), loveMusicList);
    }
}
