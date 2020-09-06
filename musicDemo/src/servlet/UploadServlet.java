package servlet;

import entity.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
    public  final String PATH = "E:\\idea\\musicDemo\\web\\music\\";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");


        User user = (User) req.getSession(false).getAttribute("user");
        if (user == null) {
            System.out.println("当前未登录, 请先登录");
            resp.getWriter().write("<h2> 当前未登录, 请先登录" + "<h2>");
            return;
        } else {
            //上传文件到服务器
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> fileItems = null;
            try {
                fileItems = upload.parseRequest(req);
            } catch (FileUploadException e) {
                e.printStackTrace();
                return;
            }

            FileItem fileItem = fileItems.get(0);
            String fileName = fileItem.getName();
            req.getSession().setAttribute("fileName", fileName);
            try {
                fileItem.write(new File(PATH, fileName));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("目录上传成功");
            //上传到数据库中
            resp.sendRedirect("uploadsucess.html");
        }
    }

}
