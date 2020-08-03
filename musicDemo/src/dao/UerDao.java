package dao;

import entity.User;
import util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UerDao {
    /**
     * 注册
     */
    public static void addUser(User user) {
        //建立连接
        Connection connection = DBUtils.getConnection();
        //构造SQL
        String sql = "insert into user values (null, ?, ?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
             statement = connection.prepareStatement(sql);
             statement.setString(1, user.getUsername());
             statement.setString(2, user.getPassword());
             //执行SQL
            int ret = statement.executeUpdate();
            if (ret == 1) {
                System.out.println("注册成功!");
            } else {
                System.out.println("注册失败!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(connection, statement, resultSet);
        }
    }

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("hm");
        user.setPassword("123");
        addUser(user);
    }

}
