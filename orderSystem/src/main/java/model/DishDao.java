package model;

import util.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 1.新增菜品
 * 2.删除菜品
 * 3.查找所有菜品
 * 4.按照dishId查找菜品
 * 5.修改菜品
 */
public class DishDao {

    //1.新增菜品
    public void add(Dish dish) throws OrderSystemException {
        //1.建立连接
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL
        PreparedStatement statement = null;
        String sql = "insert into menu values (null, ?, ?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, dish.getDishName());
            statement.setInt(2, dish.getPrice());

            //3.执行SQL
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("新增菜品失败!");
            }
            System.out.println("新增菜品成功!");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, null);
        }
    }

    //2.删除菜品
    public void delete(int dishId) throws OrderSystemException {
        //1.建立连接
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL
        PreparedStatement statement = null;
        String sql = "delete from menu where dishId = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, dishId);

            //3.执行SQL
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("删除菜品失败!");
            }
            System.out.println("删除菜品成功!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }


    //3.查找所有菜品
    public ArrayList<Dish> selectAll() throws OrderSystemException {
        ArrayList<Dish> dishes  = new ArrayList <>();
        //1.建立连接
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL
        PreparedStatement statement = null;
        String sql = "select * from menu";
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            //3.执行SQL
            resultSet = statement.executeQuery();
            //4.遍历结果集
            while (resultSet.next()) {
                Dish dish = new Dish();
                dish.setDishId(resultSet.getInt("dishId"));
                dish.setDishName(resultSet.getString("dishName"));
                dish.setPrice(resultSet.getInt("price"));
                dishes.add(dish);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("查找所有菜品失败!");
        }finally {
            //5.释放连接
            DBUtil.close(connection, statement, resultSet);
        }
        return dishes;
    }

    //4.按照dishId查找菜品
    public Dish selectById(int dishId) {
        //1.建立连接
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL
        PreparedStatement statement = null;
        String sql = "select * from menu where dishId = ?";
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, dishId);

            //3.执行SQL
            resultSet = statement.executeQuery();
            //4. 遍历结果集
            if (resultSet.next()) {
                Dish dish = new Dish();
                dish.setDishId(resultSet.getInt("dishId"));
                dish.setDishName(resultSet.getString("dishName"));
                dish.setPrice(resultSet.getInt("price"));
                return dish;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.释放连接
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }

    //5.修改菜品
    public void update(Dish dish, int newPrice) throws OrderSystemException {
        //1.建立连接
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL
        PreparedStatement statement = null;
        String sql = "update menu where dishId = ? set price = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, dish.getDishId());
            statement.setInt(2, newPrice);
            //3.执行SQL
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("修改菜单价格失败!");
            }
            System.out.println("修改菜单价格成功!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }
}
