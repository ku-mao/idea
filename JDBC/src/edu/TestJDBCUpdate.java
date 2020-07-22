package edu;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBCUpdate {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改学生的id:");
        int id = Integer.parseInt(sc.next());
        System.out.println("请输入修改后的姓名:");
        String name = sc.next();
        System.out.println("请输入修改后的班级:");
        int classId = Integer.parseInt(sc.next());
        //创建对象
        DataSource dataSource = new MysqlDataSource();
        //针对对象进行配置
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_0722?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("root");

        //2.建立连接
        Connection connection = dataSource.getConnection();

        //3.拼装SQL
        String sql = "update student set name = ?, classId = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setInt(2, classId);
        statement.setInt(3, id);

        //4.执行SQL
        int ret = statement.executeUpdate();
        if(ret == 1) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }


        //5.释放连接
        statement.close();
        connection.close();
    }
}
