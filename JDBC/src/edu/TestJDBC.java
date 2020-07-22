package edu;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//自己实现MySQL 客户端
public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        //1.创建对象
        DataSource dataSource = new MysqlDataSource();
        String URL = "jdbc:mysql://127.0.0.1:3306/java_0722?characterEncoding=utf-8&useSSL=true";
        ((MysqlDataSource) dataSource).setURL(URL);
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("root");

        //2.建立连接
        Connection connection = dataSource.getConnection();
        //3.拼装SQL
        int id = 1;
        String name = "张三";
        int classId = 1;
        // ? 就是一个占位符 是用变量值来替换的
        String sql = "insert into student values(?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
         // 1, 2, 3 是 ? 的下标, 从1开始
        statement.setInt(1, id);
        statement.setString(2, name);
        statement.setInt(3, classId);
        System.out.println(statement);
        //4.执行SQL
        int ret = statement.executeUpdate(); //create delete update 语句执行的时候都是executeUpdate()
                                  //select 语句执行的时候都是executeQuery
        //executeUpdate()执行的结果会返回一个int值
        //代表此次执行修改了多少行
        System.out.println("ret : " + ret);
        //5.释放连接
        //后创建的先释放
        statement.close();
        connection.close();
    }
}
