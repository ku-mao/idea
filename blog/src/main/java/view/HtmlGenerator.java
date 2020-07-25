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
        stringBuilder.append(String.format("<a href = \"%s\"> 点击这里跳转 </a>)",
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
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");

        stringBuilder.append("<div>欢迎您 " + user.getName() + "</div>");
        //把文章的每个标题都显示出来, 还会有一个链接, 跳转文章详情页
        for (Article article : articles) {
            stringBuilder.append(String.format("<div> <a href=\"article?articleId=%d\"> %s</div>",
                    article.getArticleId(), article.getTitle()));
        }
        stringBuilder.append(String.format("<div>共有博客 %d 篇</div>", articles.size()));
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }
}
