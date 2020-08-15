package model;

import util.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public Dish selectById(int dishId) throws OrderSystemException {
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
            throw new OrderSystemException("按照dishId查找菜品失败!");
        } finally {
            //5.释放连接
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }

    //5.修改菜品
    public void update(int dishId, int newPrice) throws OrderSystemException {
        //1.建立连接
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL
        PreparedStatement statement = null;
        String sql = "update menu set price = ? where dishId = ? ";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, newPrice);
            statement.setInt(2, dishId);
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

    public static void main(String[] args) throws OrderSystemException {
        DishDao dishDao = new DishDao();
        //1.新增菜品
//        Dish dish = new Dish();
//        dish.setDishName("红烧茄子");
//        dish.setPrice(1800);
//        dishDao.add(dish);
//        dish.setDishName("红烧鱼");
//        dish.setPrice(3500);
//        dishDao.add(dish);
//        dish.setDishName("红烧肉");
//        dish.setPrice(2500);
//        dishDao.add(dish);
        //2.查看菜单
//        System.out.println("查看菜单");
//        List<Dish> dishes = dishDao.selectAll();
//        System.out.println(dishes);
        //3.按照id查看菜品
//        Dish dish = dishDao.selectById(1);
//        System.out.println("按照Id查找菜品");
//        System.out.println(dish);
        //4.按照id删除菜品
        //dishDao.delete(3);
        //5.修改菜的价格
        dishDao.update(2, 4000);
    }
}
