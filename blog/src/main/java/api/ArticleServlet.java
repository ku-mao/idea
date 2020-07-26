package api;

import model.Article;
import model.Dao.ArticleDao;
import model.Dao.UserDao;
import model.User;
import view.HtmlGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
        String articleIdStr = req.getParameter("articleId");
        if (null == articleIdStr) {
            //3.没有articleId 转到文章列表页面
            getAllArticle(user, resp);
        } else {
            //4.有, 转去文章详情页面
            getOneArticle(Integer.parseInt(articleIdStr), user, resp);
        }
    }

    private void getAllArticle(User user, HttpServletResponse resp) throws IOException {
        ArticleDao articleDao = new ArticleDao();
        List<Article> articles = articleDao.selectAll();
        String html = HtmlGenerator.getArticleList(user, articles);
        resp.getWriter().write(html);
    }
    private void getOneArticle(int articleId, User user, HttpServletResponse resp) throws IOException {
        //1.拿到数据库的文章
        ArticleDao articleDao = new ArticleDao();
        Article article = articleDao.selectById(articleId);
        //2.判断文章是否存在
        if (null == article) {
            String html = HtmlGenerator.getMessage("文章不存在", "article");
            resp.getWriter().write(html);
            return;
        }
        //3.构造页面
        UserDao userDao = new UserDao();
        User author = userDao.selectById(article.getUserId());
        String html = HtmlGenerator.getArticleDetail(article, author, user);
        resp.getWriter().write(html);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("utf-8");
        //1.从请求中读取浏览器提交的数据(title, content),并进行校验
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        if (null == title || "".equals(title) ||
            null == content || "".equals(content)) {
            String html = HtmlGenerator.getMessage("标题或者正文为空", "article");
            resp.getWriter().write(html);
            return;
        }
        //2. 把数据插入到数据库中
        //取到当前用户的id
        HttpSession httpSession = req.getSession(true);
        User user = (User) httpSession.getAttribute("user");
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setUserId(user.getUserId());
        //3. 返回一个插入成功的页面
    }
}
