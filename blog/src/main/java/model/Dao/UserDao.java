package model.Dao;

import model.Article;
import model.DBUtil;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Dao 表示数据访问层
//通过这个UserDao类来完成针对 用户的数据库表操作
public class UserDao {
  //1.新增用户(注册)
    //把一个User 对象插入到数据库中
    public void add(User user) {
        //1.获取到数据库连接
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL 语句
        String sql = "insert into user values (null, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            //3.执行SQL 语句
            int ret = statement.executeUpdate();
            if (ret != 1) {
                System.out.println("插入新用户失败!");
                return;
            }
            System.out.println("插入新用户成功!");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, null);
        }
    }
  //2.按照名字查找用户(登录)
    public User selectByName(String name) {
        //1.连接数据库
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL
        String sql = "select * from user where name = ?";
        //3.执行SQL
        PreparedStatement statement =null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            //4.遍历结果集
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭连接
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }

    public static void main(String[] args) {
        //测试add()方法
       UserDao userDao = new UserDao();
//        User user = new User();
//        user.setName("drr");
//        user.setPassword("123456");
//        userDao.add(user);
        //测试selectByName() 方法
        System.out.println(userDao.selectByName("drr"));
    }

    public User selectById(int userId) {
        //1.连接数据库
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL
        String sql = "select * from user where userId = ?";
        //3.执行SQL
        PreparedStatement statement =null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            //4.遍历结果集
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭连接
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }
}















