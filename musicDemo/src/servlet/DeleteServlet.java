package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.MusicDao;
import entity.Music;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Map<String, Object> returnMap = new HashMap <>();
        String idStr = req.getParameter("id");
        int id = Integer.parseInt(idStr);

        MusicDao musicDao = new MusicDao();
        Music music = musicDao.findMusicById(id);
        if (music == null) {
            return;
        }
        int ret = musicDao.deleteById(id);
        if (ret == 1) {
            //数据库删除成功
            //删除服务器上的文件
            File file = new File( "E:\\idea\\musicDemo\\web\\" + music.getUrl() + ".mp3");

            if (file.delete()) {
                returnMap.put("msg", true);
                System.out.println("服务器删除成功");
            } else {
                returnMap.put("msg", false);
                System.out.println("服务器删除失败");
            }
        } else {
            returnMap.put("msg", false);
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), returnMap);
    }
}
