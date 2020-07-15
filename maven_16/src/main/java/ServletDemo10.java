import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@MultipartConfig
public class ServletDemo10 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //收到图片,直接把图片保存到 D:/images路径中
        String basePath = "D:/images";
        Part part = req.getPart("image");
        //类似于前面的getParameter
        //参数里传入一个key值,就得到一个想要获取的内容.
        //此处得到的是Part对象,part对象对应到上传的文件内容

        //这个方法就能得到上传的文件名
        String path = basePath + part.getSubmittedFileName();
        part.write(path);
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write("图片上传成功");
    }
}
