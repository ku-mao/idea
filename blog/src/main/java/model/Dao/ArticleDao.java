package model.Dao;

import model.Article;
import model.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//通过这个类完成针对文章的数据库表操作
public class ArticleDao {
    //1.新增博客
    public void add(Article article) {
        //1.获取数据库连接
        Connection connection = DBUtil.getConnection();
        //2.构造SQL
        String sql = "insert into article values(null, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, article.getTitle());
            statement.setString(2, article.getContent());
            statement.setInt(3, article.getUserId());
            //3.执行SQL语句
            int ret = statement.executeUpdate();
            if (ret != 1) {
                System.out.println("发布文章失败!");
                return;
            }
            System.out.println("发布文章成功!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //4.释放连接
            DBUtil.close(connection, statement, null);
        }
    }

    //2.查看文章列表(不查正文)
    public List<Article> selectAll() {
        List<Article> articles = new ArrayList <>();
        //1.连接数据库
        Connection connection = DBUtil.getConnection();
        //2.构造sql
        String sql = "select articleId, title, userId from article";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            //3.执行sql
            resultSet = statement.executeQuery();
            //4.遍历结果集
            while (resultSet.next()) {
                Article article = new Article();
                article.setArticleId(resultSet.getInt("articleId"));
                article.setTitle(resultSet.getString("title"));
                article.setUserId(resultSet.getInt("userId"));
                articles.add(article);
            }
            return articles;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            //5.释放连接
            DBUtil.close(connection, statement, resultSet);
        }
        return null;

    }
    //3.查看指定文章详情(查正文)
    public Article selectById(int articleId) {
        //1.连接数据库
        Connection connection = DBUtil.getConnection();
        //2.构造SQL
        String sql = "select * from article where articleId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, articleId);
            //3.执行SQL
           resultSet = statement.executeQuery();
           //4.遍历结果集
           if (resultSet.next()) {
               Article article = new Article();
               article.setArticleId(resultSet.getInt("articleId"));
               article.setTitle(resultSet.getString("title"));
               article.setContent(resultSet.getString("content"));
               article.setUserId(resultSet.getInt("userId"));
               return article;
           }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭连接
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }
    //4.删除指定文章
    public void delete(int articleId) {
        //1.连接数据库
        Connection connection = DBUtil.getConnection();
        //2.构造SQL
        String sql = "delete from article where articleId = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, articleId);
            //3.执行SQL
            int ret = statement.executeUpdate();
            if (ret != 1) {
                System.out.println("删除文章失败!");
                return;
            }
            System.out.println("删除文章成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //4.关闭连接
            DBUtil.close(connection, statement, null);
        }
    }

    public static void main(String[] args) {
        //测试 新增文章
        ArticleDao articleDao = new ArticleDao();
//        Article article = new Article();
//        article.setTitle("标题1");
//        article.setContent("我是正文我是正文我是正文我是正文我是正文我是正文");
//        article.setUserId(1);
//        articleDao.add(article);
//        Article article = new Article();
//        article.setTitle("标题2");
//        article.setContent("我是正文2我是正文2我是正文2我是正文2我是正文2我是正文2");
//        article.setUserId(1);
//        articleDao.add(article);

        //测试查看文章列表
//        System.out.println(articleDao.selectAll());

        //测试查看文章正文
//        System.out.println(articleDao.selectById(2));
        //测试删除文章
 //       articleDao.delete(1);

    }
}
