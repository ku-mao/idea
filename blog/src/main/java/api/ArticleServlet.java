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
import java.util.List;

public class ArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        //1.判断用户是否登录
        HttpSession httpSession = req.getSession(false);
        if (httpSession == null) {
            String html = HtmlGenerator.getMessage("请先登录", "login.html");
            resp.getWriter().write(html);
            return;
        }
        User user = (User)httpSession.getAttribute("user");
        //2.看请求路径中是否有articleId 字段
        String articleId = req.getParameter("articleId");
        if (null == articleId) {
            //3.没有articleId 转到文章列表页面
            getAllArticle(user, resp);
        } else {
            //4.有, 转去文章详情页面
            getOneArticle();
        }
    }

    private void getAllArticle(User user, HttpServletResponse resp) throws IOException {
        ArticleDao articleDao = new ArticleDao();
        List<Article> articles = articleDao.selectAll();
        String html = HtmlGenerator.getArticleList(user, articles);
        resp.getWriter().write(html);
    }
    private void getOneArticle() {
    }
}
