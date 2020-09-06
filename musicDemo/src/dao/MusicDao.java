package dao;

import entity.Music;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicDao {

    /**
     * 查找全部音乐
     */
    public List<Music> findAll() {
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
                music.setTime(resultSet.getDate("time"));
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
    public  Music selectById(int id) {
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
                music.setTime(resultSet.getDate("time"));
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

    /**
     * 按照关键词模糊查询歌单
     */
    public  List<Music> ifMusic(String str) {
        List<Music> musicList = new ArrayList <>();
        Connection connection = DBUtil.getConnection();
        String sql = "select * from music where title like '%" + str + "%'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Music music = new Music();
                music.setId(resultSet.getInt("id"));
                music.setTitle(resultSet.getString("title"));
                music.setSinger(resultSet.getString("singer"));
                music.setTime(resultSet.getDate("time"));
                music.setUrl(resultSet.getString("url"));
                music.setUserId(resultSet.getInt("userId"));
                musicList.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return musicList;
    }

    /**
     * 上传音乐
     * 分为2步
     * 1.上传音乐给服务器
     * 2.上传音乐给数据库 (现在实现的)
     */
    public void add(String title, String singer, String time, String url, int userId) {
        Connection connection = DBUtil.getConnection();
        String sql = "insert into music (title, singer, time, url, userId) values (?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, singer);
            statement.setString(3, time);
            statement.setString(4, url);
            statement.setInt(5, userId);
            int ret = statement.executeUpdate();
            if (ret == 1) {
                System.out.println("上传成功!");
            } else {
                System.out.println("上传失败!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, null);
        }
    }

    /**
     * 按照id删除音乐
     */
    public int deleteById(int id) {
       Connection connection = DBUtil.getConnection();
       String sql = "delete from music where id = ?";
       PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int ret = statement.executeUpdate();
            if (ret == 1) {
                //还要判断是否在中间表中
                if(findLoveMusic(id)) {
                    int ret2 = removeLoveMusic(id);
                    if(ret2 == 1) {
                        System.out.println("删除成功!");
                        return 1;
                    }
                }
            }
            System.out.println("删除失败!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
        return 0;
    }

    public boolean findLoveMusic(int id) {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from lovemusic where musicId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return false;
    }

    /**
     * 删除音乐的时候还要把喜欢列表里的音乐删除
     */
    private int removeLoveMusic(int id) {
        Connection connection = DBUtil.getConnection();
        String sql = " delete from lovemusic where musicId = ?";
        PreparedStatement statement = null;
        int ret = 0;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ret = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, null);
        }
        return ret;
    }

    /**
     * 批量删除音乐
     */
//    public void deleteSelMusic(int[] ids) {
//        Connection connection = DBUtil.getConnection();
//        String sql = "delete from music where id = ?";
//        PreparedStatement statement = null;
//        try {
//            statement = connection.prepareStatement(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            DBUtil.close(connection, statement, null);
//        }
//    }


    /**
     * 在添加喜欢的音乐之前先判断这个喜欢的音乐是否存在
     */
    public boolean findLoveMusicById(int userId, int musicId ) {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from lovemusic where userId = ? and musicId = ? ";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2, musicId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("该音乐已经存在在喜欢列表");
        return false;
    }

    /**
     * 添加到喜欢列表
     */
    public void addLoveMusic(int userId, int musicId) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        String sql = "insert into lovemusic values (null, ?, ?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2, musicId);
            int ret = statement.executeUpdate();
            if (ret == 1) {
                System.out.println("添加到喜欢列表成功!");
                return;
            }
            System.out.println("添加到喜欢列表失败!");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, null);
        }
    }

    /**
     * 删除喜欢的音乐
     * 删除当前用户喜欢的这首音乐，
     * 因为同一首音乐可能多个用户喜欢
     */
    private void deleteLoveMusic(int userId, int musicId) {
        Connection connection = DBUtil.getConnection();
        String sql = " delete from lovemusic where userId = ? and musicId = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2, musicId);
            int ret = statement.executeUpdate();
            if (ret == 1) {
                System.out.println("删除喜欢的音乐成功!");
                return;
            }
            System.out.println("删除喜欢的音乐成功!");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, null);
        }
    }

    /**
     * 查找所有喜欢音乐的列表
     * @param userId
     * @return
     */
    public List<Music> findAllLoveMusic(int userId) {
        List<Music> list = new ArrayList <>();
        Connection connection = DBUtil.getConnection();
        String sql = "select m.id as musicId, title, singer,time, url, m.userId from lovemusic lm, music m where lm.musicId = m.id and m.userId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Music music = new Music();
                music.setId(resultSet.getInt("musicId"));
                music.setTitle(resultSet.getString("title"));
                music.setSinger(resultSet.getString("singer"));
                music.setTime(resultSet.getDate("time"));
                music.setUrl(resultSet.getString("url"));
                music.setUserId(resultSet.getInt("userId"));
                list.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return list;
    }


    /**
     * 喜欢音乐列表页的模糊查询
     */

    public List<Music> findIfLoveMusic(String str, int userId) {
        List<Music> list = new ArrayList <>();
        Connection connection = DBUtil.getConnection();
        String sql = "select m.id as musicId, title, singer,time, url, m.userId from lovemusic lm, music m " +
                "where lm.musicId = m.id and m.userId = ? and title like '%" + str  + "%'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Music music = new Music();
                music.setId(resultSet.getInt("musicId"));
                music.setTitle(resultSet.getString("title"));
                music.setSinger(resultSet.getString("singer"));
                music.setTime(resultSet.getDate("time"));
                music.setUrl(resultSet.getString("url"));
                music.setUserId(resultSet.getInt("userId"));
                list.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return list;
    }

    public static void main(String[] args) {
        MusicDao musicDao = new MusicDao();
//        musicDao.add("暖暖", "梁静茹", "2020-9-5","music/暖暖",2);
//        musicDao.deleteById(1);
//        musicDao.addLoveMusic(1, 2);
//         System.out.println(musicDao.deleteLoveMusic(2));
    // System.out.println(musicDao.findAllLoveMusic(1));
        //System.out.println(musicDao.findIfLoveMusic("不", 1));
        //System.out.println(musicDao.ifMusic("夏"));
    }
}
