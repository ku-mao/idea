package model;

import util.OrderSystemException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 1.新增订单
 * 2.查看所有订单
 * 3.查看指定用户的订单
 * 4.查看订单详细信息
 * 5.修改订单的状态
 */
public class OrderDao {
    //1.新增订单
    public void add(Order order) throws OrderSystemException {
        //这里的新增订单涉及到两张表 order_user 和 order_dish 表 因为 order里面有个List<Dish> dishes 属性
        //1) 先在order_user表里面添加记录
        addOrderUser(order);
        //2) 在order_dish表里面添加记录
        addOrderDish(order);
    }

    private void addOrderUser(Order order) throws OrderSystemException {
        //1.获取连接
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL
        String sql = "insert into order_user values (null, ?, now(), 0)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //因为在执行addOrderDish 表的时候需要知道orderId(是oder_user表的外键)
            // 这里代码执行sql只是在数据库中有自增值 但是代码中不知道, 所以要用RETURN_GENERATED_KEYS 参数来返回
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, order.getUserId());
            //3.执行SQL
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("新增订单的第一步失败!");
            }
            System.out.println("新增订单第一步成功!");
            //这里是获取到自增值, 然后给代码中的Order 对象设置值
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                // 我们读取resultSet结果的时候不仅可以用列名获取也可以用下标来获取
                //一个表中的自增组件可能有很多, 返回的时候都返回了, 所以用下标1获取第一个自增列生成的值
                order.setOrderId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("新增订单的第一步失败!");
        } finally {
            //4.释放连接
            DBUtil.close(connection, statement, resultSet);
        }
    }



    //因为一个订单中有很多菜品, 所以一次会插入多条数据, 这里采用1条sql 多个值的方式插入
    private void addOrderDish(Order order) throws OrderSystemException {
        //1.获取连接
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL
        String sql = "insert into order_dish values (?, ?)";
        PreparedStatement statement = null;
        try {
            //3.关闭自动提交
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            //由于一个订单对应多个菜品, 所以要遍历order中包含的所有菜品list
            //4.遍历dishes 给SQL 添加多个values
            List<Dish> dishes = order.getDishes();
            for (Dish dish : dishes) {
                statement.setInt(1, order.getOrderId());
                statement.setInt(2, dish.getDishId());
                statement.addBatch();//给sql新增一个片段
            }
            //5.执行SQL
            statement.executeBatch();//执行刚才的sql语句(不是真的执行)
            //6.发送给服务器
            connection.commit();//commit 可以执行多个sql, 一次调用就会打多个sql一次发给服务器
        } catch (SQLException e) {
            e.printStackTrace();
            deleteOrderUser(order.getOrderId());
        } finally {
            //7.释放连接
            DBUtil.close(connection, statement, null);
        }
    }

    private void deleteOrderUser(int orderId) throws OrderSystemException {
        //1.获取连接
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL
        String sql = "delete from order_user where orderId = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);
            //3.执行SQL
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("回滚失败!");
            }
            System.out.println("回滚成功!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("回滚失败!");
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    //2.获取所有订单(这里不获取详细的菜品, 在selectById接口实现)
    public List<Order> selectAll() {
        List<Order> orders = new ArrayList <>();
        //1.获取连接
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL
        String sql = "select * from order_user";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            //3.执行SQL
            resultSet = statement.executeQuery();
            //4.遍历结果集
            while(resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderId"));
                order.setUserId(resultSet.getInt("userId"));
                order.setTime(resultSet.getTimestamp("time"));
                order.setIsDone(resultSet.getInt("isDone"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //5.释放连接
            DBUtil.close(connection, statement, resultSet);
        }
        return orders;
    }

    //查看指定用户的订单
    public List<Order> selectByUserId(int userId) {
        List<Order> orders = new ArrayList <>();
        //1.建立连接
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL
        String sql = "select * from order_user where userId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            //3. 执行SQL
            resultSet = statement.executeQuery();
            //4.遍历结果集
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderId"));
                order.setUserId(resultSet.getInt("userId"));
                order.setTime(resultSet.getTimestamp("time"));
                order.setIsDone(resultSet.getInt("isDone"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.释放连接
            DBUtil.close(connection, statement, resultSet);
        }
        return orders;
    }

    //查看订单的详细信息(订单里面的所有菜品, 包括菜品的价格, 名字)
    public Order selectByOderId(int orderId) throws OrderSystemException {
        //1.先根据一个orderId找到一个Order对象
        Order order = createOrder(orderId);
        //2.根据orderId, 在order_dish表找到一个dishId的一个列表
        List<Integer> dishIds = findDishId(orderId);
        //3.根据dishId在menu表中找到菜的详细信息
        order = getDishDetail(order, dishIds);
        return order;
    }

    private Order createOrder(int orderId) {
        //1.建立连接
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL
        String sql = "select * from order_user where orderId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);
            //3.执行SQL
            resultSet = statement.executeQuery();
            //4.遍历结果集
            if (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderId"));
                order.setUserId(resultSet.getInt("userId"));
                order.setTime(resultSet.getTimestamp("time"));
                order.setIsDone(resultSet.getInt("isDone"));
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.释放连接
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }

    private List<Integer> findDishId(int orderId) {
        List<Integer> dishIds = new ArrayList <>();
        //1.建立连接
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL
        String sql = "select dishId from order_dish where orderId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);
            //3.执行SQL
            resultSet = statement.executeQuery();
            //4.遍历结果集
            while (resultSet.next()) {
                dishIds.add(resultSet.getInt("dishId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.释放连接
            DBUtil.close(connection, statement, resultSet);
        } return dishIds;
    }

    private Order getDishDetail(Order order, List<Integer> dishIds) throws OrderSystemException {
        //1.准备一个List 存放菜品
        List<Dish> dishes = new ArrayList <>();
        //2.遍历dishIds 在menu表中找
        DishDao dishDao = new DishDao();
        for (Integer dishId : dishIds) {
            Dish dish = dishDao.selectById(dishId);
            dishes.add(dish);
        }
        order.setDishes(dishes);
        return order;
    }

    //修改订单的状态
    public void changeState(int orderId, int isDone) throws OrderSystemException {
        //1.建立连接
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL
        String sql = "update order_user set isDone = ? where orderId = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, isDone);
            statement.setInt(2, orderId);
            //3.执行SQL
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("修改订单状态失败!");
            }
            System.out.println("修改订单状态成功!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("修改订单状态失败!");
        } finally {
            //4.释放连接
            DBUtil.close(connection, statement, null);
        }
    }

    public static void main(String[] args) {
//        OrderDao orderDao = new OrderDao();
//        Order order = new Order();
//        order.setUserId(1);
//        order.setTime();
    }
}
