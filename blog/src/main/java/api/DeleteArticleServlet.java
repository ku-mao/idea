package api;

import model.Article;
import model.Dao.ArticleDao;
import model.User;
import view.HtmlGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class DeleteArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        //1.查看用户的登录状态, 未登录无法删除
        HttpSession httpSession = req.getSession(false);
        User user = (User) httpSession.getAttribute("user");
        if (user == null) {
            String html = HtmlGenerator.getMessage("未登录, 不能删除文章",
                    "login.html");
            resp.getWriter().write(html);
            return;
        }
        //2.从请求中获取到articleId.
        String articleIdStr = req.getParameter("articleId");
        if (null == articleIdStr || "".equals(articleIdStr)) {
            String html = HtmlGenerator.getMessage("您删除的文章不存在",
                    "article");
            resp.getWriter().write(html);
            return;
        }
        int articleId = Integer.parseInt(articleIdStr);
        //3.根据articleId找到用户id, 看是否用户是否是作者, 不是则不能删除
        ArticleDao articleDao = new ArticleDao();
        Article article = articleDao.selectById(articleId);
        int userId = article.getUserId();
        if (userId != user.getUserId()) {
            String html = HtmlGenerator.getMessage("您只能删除您自己的博客",
                    "article");
            resp.getWriter().write(html);
            return;
        }
        //4.真正的删除数据库的内容
        articleDao.delete(articleId);
        //5.返回一个删除成功的页面
        String html = HtmlGenerator.getMessage("删除成功",
                "article");
        resp.getWriter().write(html);
    }
}
