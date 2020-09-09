package dao;

import entity.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    /**
     * 注册
     */
    public  void addUser(User user) {
        //建立连接
        Connection connection = DBUtil.getConnection();
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
            DBUtil.close(connection, statement, resultSet);
        }
    }

    public  User login(String userName) {
        //1.建立连接
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL
        String sql = "select * from user where username = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = new User();
        try {
             statement = connection.prepareStatement(sql);
             statement.setString(1, userName);
             //3.执行SQL
            resultSet = statement.executeQuery();
            //4.遍历结果集
            if (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放连接
            DBUtil.close(connection, statement, resultSet);
        }
        return user;
    }

    public User findByName(String username) {
        //1.建立连接
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL
        String sql = "select * from user where username = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            //3.执行SQL
            resultSet = statement.executeQuery();
            //4.遍历结果集
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }

    public static void main(String[] args) {
       // UserDao userDao = new UserDao();
        //测试注册
//        User user = new User();
//        user.setUsername("hm");
//        user.setPassword("123");
//        userDao.addUser(user);
        //测试登录
//        User user = userDao.login("drr");
//        System.out.println(user);

    }

}
