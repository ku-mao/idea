package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Dish;
import model.Order;
import model.OrderDao;
import model.User;
import util.GetBodyUtil;
import util.OrderSystemException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单管理
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    Gson gson = new GsonBuilder().create();

    static class Response {
        public int ok;
        public String reason;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response response = new Response();
        try {
            //1.检查登录状态
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("尚未登录, 请先登录");
            }
            User user = (User)session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("尚未登录, 请先登录");
            }
            //2.检查是否是管理员(管理员不能新增订单)
            if (user.getIsAdmin() == 1) {
                throw new OrderSystemException("管理员不能添加订单");
            }
            //3.解析body
            String body = new GetBodyUtil().getBody(req);
            //4.构造一个json请求对象
            Integer[] dishIds = gson.fromJson(body, Integer[].class);
            //List<Integer> dishIds = gson.fromJson(body, new TypeToken<Integer>() {}.getType());
            //5.构造order对象
            //order里面的orderId, time, isDone, Dish里面的dishName, price都不用填充
            Order order = new Order();
            order.setUserId(user.getUserId());
            List<Dish> dishes = new ArrayList<>();
            for (Integer dishId : dishIds) {
                Dish dish = new Dish();
                dish.setDishId(dishId);
                dishes.add(dish);
            }
            order.setDishes(dishes);
            //6.在数据库中新增数据
            OrderDao orderDao = new OrderDao();
            orderDao.add(order);
            //7.构造响应json对象
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            //8.返回json字符串
            resp.setContentType("application/json; charset=utf-8");
            String jsonStr = gson.toJson(response);
            resp.getWriter().write(jsonStr);
        }
    }

    /**
     *查看订单/详情
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Response response = new Response();
        try {
            //1.查看登录是否登录
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("尚未登录, 请先登录");
            }
            User user = (User)session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("尚未登录, 请先登录");
            }
            //2.判断orderId字段是否存在
            List<Order> orders = new ArrayList <>();
            OrderDao orderDao = new OrderDao();
            String orderIdStr = req.getParameter("orderId");
            if (orderIdStr == null) {
                //3.查看是管理员还是普通用户
                if (user.getIsAdmin() == 0) {
                    //4.查看数据库, 查找所有订单
                    orders = orderDao.selectByUserId(user.getUserId());
                } else {
                    orders = orderDao.selectAll();
                }
                //5.构造响应
                String jsonStr = gson.toJson(orders);
                resp.getWriter().write(jsonStr);
            } else  {
                //4.查看数据库, 查找指定订单
                int orderId = Integer.parseInt(orderIdStr);
                Order order = orderDao.selectByOderId(orderId);
                //判断是管理员还是普通用户
                //管理员可以查看,
                // 普通用户的userId和订单中的UserId相等才能查看
                if (user.getIsAdmin() == 0 && user.getUserId() != order.getUserId()) {
                    throw new OrderSystemException("你无权查看别人的订单");
                }
                //5.构造响应
                String jsonStr = gson.toJson(order);
                resp.getWriter().write(jsonStr);
            }
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
            String jsonStr = gson.toJson(response);
            resp.getWriter().write(jsonStr);
        }
    }

    /**
     * 修改订单状态
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Response response = new Response();
        req.setCharacterEncoding("utf-8");
        try {
            //1.检查登录状态
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("尚未登录, 请先登录");
            }
            User user = (User)session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("尚未登录, 请先登录");
            }
            //2.检查是否是管理员
            if (user.getIsAdmin() == 0) {
                throw new OrderSystemException("你不是管理员, 不能修改订单状态");
            }
            //3.获取到orderId 和 isDone
            String orderIdStr = req.getParameter("orderId");
            String isDoneStr = req.getParameter("isDone");
            if (orderIdStr == null || isDoneStr == null) {
                throw new OrderSystemException("参数错误");
            }
            //4.修改数据库
            int orderId = Integer.parseInt(orderIdStr);
            int isDone = Integer.parseInt(isDoneStr);
            OrderDao orderDao = new OrderDao();
            orderDao.changeState(orderId, isDone);
            //5.构造json响应对象
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            //6.返回json字符串
            resp.setContentType("application/json; charset=utf-8");
            String jsonStr = gson.toJson(response);
            resp.getWriter().write(jsonStr);
        }
    }
}
