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

@WebServlet("/loveMusicServlet")
public class LoveMusicServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.getWriter().write("当前尚未登录, 请先登录");
            return;
        }
        int userId = user.getId();
        String idStr = req.getParameter("id");
        int musicId = Integer.parseInt(idStr);
        Map<String, Object> returnMap = new HashMap <>();
        MusicDao musicDao = new MusicDao();
        boolean ret = musicDao.findLoveMusicById(userId, musicId);
        if (ret) {
            //之前已经被你添加过
            returnMap.put("msg", false);
        } else {
            ret = musicDao.addLoveMusic(userId, musicId);
            if (ret) {
                returnMap.put("msg", true);
            } else {
                returnMap.put("msg", false);
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), returnMap);
    }
}
