package edu;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBCDelete {
    public static void main(String[] args) throws SQLException {
        //1.创建对象
        DataSource dataSource = new MysqlDataSource();
        //配置URL User Password
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_0722?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("root");

        //2.建立连接
        Connection connection = dataSource.getConnection();

        //3.拼装SQL
        int id = 1;
        String sql = "delete from student where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        //4.执行SQL
        int ret = statement.executeUpdate();
        System.out.println("ret:" + ret);

        //5.释放连接
        statement.close();
        connection.close();
    }
}
