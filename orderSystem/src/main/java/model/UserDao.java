package model;

import sun.security.pkcs11.Secmod;
import util.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//1.新增用户 -- 注册
//2.按名字查找用户 -- 登录
//3.按id查找用户信息 -- 需要获取到用户的useId
public class UserDao {

    //1.新增用户
    public void add(User user) throws OrderSystemException {
        //1.建立连接
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL
        String sql = "insert into user values (null, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getIsAdmin());
            //3.执行SQL
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("注册失败");
            }
            System.out.println("注册成功!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("注册失败");
        } finally {
            //4.释放连接
            DBUtil.close(connection, statement, null);
        }
    }

    //2.按名字查找用户
    public User selectByName(String name) throws OrderSystemException {
        //1.建立连接
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL
        String sql = "select * from user where name = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            //3.执行SQL
            resultSet = statement.executeQuery();
            //4.遍历结果集
            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setIsAdmin(resultSet.getInt("isAdmin"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("查找用户失败!");
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }

    //3.按userId查找用户
    public User selectById(int userId) throws OrderSystemException {
        //1.建立连接
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL
        String sql = "select * from user where userId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            //3.执行SQL
            resultSet = statement.executeQuery();
            //4.遍历结果集
           if (resultSet.next()) {
               User user = new User();
               user.setUserId(resultSet.getInt("userId"));
               user.setName(resultSet.getString("name"));
               user.setPassword(resultSet.getString("password"));
               user.setIsAdmin(resultSet.getInt("isAdmin"));
               return user;
           }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("按userId查找用户失败!");
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }
}
