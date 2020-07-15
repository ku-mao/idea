package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Dao 表示数据访问层
//UserDao
public class UserDao {
  //1.新增用户(注册)
    //把一个User 对象插入到数据库中
    void add(User user) {
        //1.获取到数据库连接
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL 语句
        String sql = "insert into user values (null, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //3.执行SQL 语句
        //4.释放数据库的连接
    }
  //2.按照名字查找用户(登录)

}















