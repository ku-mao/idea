package edu;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBCSelect {
    public static void main(String[] args) throws SQLException {
        //1.创建对象
        DataSource dataSource = new MysqlDataSource();
        //针对对象进行配置
        String URL = "jdbc:mysql://127.0.0.1:3306/java_0722?characterEncoding=utf-8&useSSL=true";
        ((MysqlDataSource) dataSource).setURL(URL);
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("root");
        //2.建立连接 建立连接的目的是确认网络通信是否正常
        Connection connection = dataSource.getConnection();

        //3.拼装SQL
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);
        //4.执行SQL
        ResultSet resultSet = statement.executeQuery();

        //5.遍历结果集
        //ResultSet 结果集 和迭代很像 相当于一张表, 有很多行, 每一行又有很多列
        // next()判断是否有下一行, 如果存在就获取这一行,不存在就返回
        // 可以把他当成一个光标
        // 初始情况下resultSet的光标不指向任何记录.
        //第一次调用next就会判定当前是否结果集为空
        //如果为空,直接next就返回false.
        //如果非空, next就会返回true同时让光标指向第一行记录
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int classId = resultSet.getInt("classId");
            System.out.println("id : " + id + " name : " + name + " classId : " + classId);
        }

        //6. 释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
