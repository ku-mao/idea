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

@WebServlet("/deleteSelMusicServlet")
public class DeleteSelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        String[] ids = req.getParameterValues("id[]");
        MusicDao musicDao = new MusicDao();
        Map<String, Object> returnMap = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < ids.length; i++) {
            int id = Integer.parseInt(ids[i]);
            Music music = musicDao.findMusicById(id);

            int ret = musicDao.deleteById(id);//删除数据库
            if (ret == 1) {
                File file = new File( "/root/java16/apache-tomcat-8.5.57/webapps/musicPlayer/" + music.getUrl() + ".mp3");
                if (file.delete()) {
                   sum += ret;
                } else {
                    returnMap.put("msg", false);
                    System.out.println("服务器删除失败");
                }
            } else {
                returnMap.put("msg", false);
                System.out.println("数据库删除失败");
            }
        }

        if (sum == ids.length) {
            returnMap.put("msg", true);
        } else {
            returnMap.put("msg", false);
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), returnMap);
    }

}
