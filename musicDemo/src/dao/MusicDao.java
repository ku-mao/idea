package dao;

import entity.Music;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusicDao {

    /**
     * 查找全部音乐
     */
    public static List<Music> findAll() {
        List<Music> list = new ArrayList <>();
        //1.建立连接
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL
        String sql = "select * from music";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            //3.执行SQL
            resultSet = statement.executeQuery();
            //4.遍历结果集
            while (resultSet.next()) {
                Music music = new Music();
                music.setId(resultSet.getInt("id"));
                music.setTitle(resultSet.getString("title"));
                music.setSinger(resultSet.getString("singer"));
                music.setTime(resultSet.getTime("time"));
                music.setUrl(resultSet.getString("url"));
                music.setUserId(resultSet.getInt("userId"));
                list.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //5.释放连接
            DBUtil.close(connection, statement, resultSet);
        }
        return list;
    }

    /**
     * 按照id找音乐
     */
    public static Music selectById(int id) {
        Music music = new Music();
        Connection connection = DBUtil.getConnection();
        String sql = "select * from music where id = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                music.setId(resultSet.getInt("id"));
                music.setTitle(resultSet.getString("title"));
                music.setSinger(resultSet.getString("singer"));
                music.setTime(resultSet.getTime("time"));
                music.setUrl(resultSet.getString("url"));
                music.setUserId(resultSet.getInt("userId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return music;
    }
}
