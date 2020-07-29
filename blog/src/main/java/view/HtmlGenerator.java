package view;

import model.Article;
import model.User;

import java.util.List;

public class HtmlGenerator {
    //通过一个字符串拼接的方式,构造一个html页面
    public static String getMessage(String message, String nextURL) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset=\"utf-8\">");
        stringBuilder.append("<title>提示页面</title>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");

        stringBuilder.append("<h3>");
        stringBuilder.append(message);
        stringBuilder.append("</h3>");
        stringBuilder.append(String.format("<a href = \"%s\"> 点击这里跳转 </a>",
                nextURL));

        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }

    public static String getArticleList(User user, List<Article> articles) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset=\"utf-8\">");
        stringBuilder.append("<title>提示页面</title>");
        stringBuilder.append("<style>");
        stringBuilder.append(".article {" +
                            "color: black;" +
                            "text-decoration: none;" +
                           // "display: inline-block;" +
                            "width: 200px;" +
                            "height: 50px" +
                            "}");//修改链接的颜色
        stringBuilder.append("a:hover {" +
                            "color: white;" +
                            "background-color: red;" +
                            "}");//鼠标放在上面的颜色
        stringBuilder.append("body {"+
                            "background-image: url(\"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1596011849351&di=2ea11d92170cc3b0bd679645239d8c94&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2Fb%2F58705f2c2ad41.jpg\");" +
                            "background-repeat: none;" +
                            "background-position: 0 center;" +
                            "}");//加背景图片
        stringBuilder.append("</style>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");

        stringBuilder.append("<h3>欢迎您 " + user.getName() + "</h3>");
        stringBuilder.append("<hr>");
        //把文章的每个标题都显示出来, 还会有一个链接, 跳转文章详情页
        for (Article article : articles) {
            stringBuilder.append(String.format("<div style=\"width: 200px; height: 50px; line-height: 50px\"> <a class = article href=\"article?articleId=%d\"> %s</a> " +
                            "<a href=\"deleteArticle?articleId=%d\">删除</a></div>",
                    article.getArticleId(), article.getTitle(), article.getArticleId()));
        }
        stringBuilder.append("<hr>");
        stringBuilder.append(String.format("<div>共有博客 %d 篇</div>", articles.size()));

        //在这里实现添加文章的逻辑
        stringBuilder.append("<div>发布博客</div>");
        stringBuilder.append("<div>");
        stringBuilder.append("<form action=\"article\" method=\"post\">");
        stringBuilder.append("<input type=\"text\" style=\"width: 500px; margin-bottom: 5px\" name=\"title\" placeholder=\"请输入标题\">");
        stringBuilder.append("</br>");
        stringBuilder.append("<textarea name=\"content\" style=\"width: 500px; height: 300px;\"></textarea>");
        stringBuilder.append("</br>");
        stringBuilder.append("<input type=\"submit\" value=\"发布博客\">");
        stringBuilder.append("</form>");
        stringBuilder.append("</div>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }

    public static String getArticleDetail(Article article, User author, User user) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset=\"utf-8\">");
        stringBuilder.append("<title>提示页面</title>");
        stringBuilder.append("<style>");
        stringBuilder.append("a {" +
                "color: black;" +
                "text-decoration: none;" +
                "display: inline-block;" +
                "width: 200px;" +
                "height: 50px" +
                "}");//修改链接的颜色
        stringBuilder.append("a:hover {" +
                "color: white;" +
                "background-color: red;" +
                "}");//鼠标放在上面的颜色
        stringBuilder.append("body {"+
                "background-image: url(\"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1596011849351&di=2ea11d92170cc3b0bd679645239d8c94&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2Fb%2F58705f2c2ad41.jpg\");" +
                "background-repeat: none;" +
                "background-position: 0 center;" +
                "}");//加背景图片
        stringBuilder.append("</style>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");

        stringBuilder.append("<h3>欢迎您 " + user.getName() + "</h3>");
        stringBuilder.append("<hr>");

        stringBuilder.append("<h1> 文章标题: " + article.getTitle() + "</h1>");
        stringBuilder.append(String.format("<h4> 作者姓名: %s </h4>", author.getName()));
        stringBuilder.append(String.format("<div> 正文: %s </div>" ,article.getContent().replace("\n", "</br>")));
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }
}
