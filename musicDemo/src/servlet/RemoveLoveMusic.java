package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.MusicDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/removeLoveServlet")
public class RemoveLoveMusic extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        String idStr = req.getParameter("id");
        int loveMusicId = Integer.parseInt(idStr);
        User user = (User) req.getSession(false).getAttribute("user");

        Map<String, Object> returnMap = new HashMap<>();
        MusicDao musicDao = new MusicDao();
        int ret = musicDao.deleteLoveMusic(user.getId(), loveMusicId);
        if (ret == 1) {
            returnMap.put("msg", true);
        } else {
            returnMap.put("msg", false);
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), returnMap);
    }
}
