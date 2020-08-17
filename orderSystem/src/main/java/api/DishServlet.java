package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Dish;
import model.DishDao;
import model.User;
import org.omg.CORBA.StringHolder;
import util.GetBodyUtil;
import util.OrderSystemException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 菜品管理
 */
@WebServlet("/dish")
public class DishServlet extends HttpServlet {
    Gson gson = new GsonBuilder().create();
    static class Request {
        public String dishName;
        public int price;
    }
    static class Response {
        public int ok;
        public String reason;
    }

    /**
     * 新增菜品
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response response = new Response();
        try {
            //1.检查用户的登录状态
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("尚未登录, 请先登录");
            }
            User user = (User)session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("尚未登录, 请先登录");
            }
            //2.检查用户是否是管理员
            if (user.getIsAdmin() == 0) {
                throw new OrderSystemException("你不是管理员, 不能添加菜品");
            }
            //3.读取请求body
            String body = new GetBodyUtil().getBody(req);
            //4.构造请求对象
            Request request = gson.fromJson(body, Request.class);
            //5.构造Dish 对象, 存入到数据库中
            Dish dish = new Dish();
            dish.setDishName(request.dishName);
            dish.setPrice(request.price);
            DishDao dishDao = new DishDao();
            dishDao.add(dish);
            //6.构造json对象
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            //7.返回json字符串
            resp.setContentType("application/json; charset=utf-8");
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }

    /**
     * 删除菜品
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            //2.检查是否是管理员
            if (user.getIsAdmin() == 0) {
                throw new OrderSystemException("你不是管理员, 不能删除菜品");
            }
            //3.获取到dishId
            String dishIdStr = req.getParameter("dishId");
            if (dishIdStr == null) {
                throw new OrderSystemException("要删除的菜品不存在");
            }
            //4.在数据库删除对应的数据
            DishDao dishDao = new DishDao();
            dishDao.delete(Integer.parseInt(dishIdStr));
            //5.构造json对象
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            //5.返回json字符串
            resp.setContentType("application/json; charset=utf-8");
            String jsonStr = gson.toJson(response);
            resp.getWriter().write(jsonStr);
        }
    }

    /**
     * 查看所有菜品
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Response response = new Response();
        //1.检查登录状态
        try {
            HttpSession session = req.getSession(false);
            if(session == null) {
                throw new OrderSystemException("尚未登录, 请先登录");
            }
            User user = (User)session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("尚未登录, 请先登录");
            }
            //2.在数据库中找数据
            DishDao dishDao = new DishDao();
            List<Dish> dishes = dishDao.selectAll();
            //因为这是一个链表, 一个数值
            //3. 直接返回给页面
            String jsonStr = gson.toJson(dishes);
            resp.getWriter().write(jsonStr);
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
            String jsonStr = gson.toJson(response);
            resp.getWriter().write(jsonStr);
        }
    }

    /**
     * 修改菜品价格
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response response = new Response();
        try {
            //1.查看登录状态
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("尚未登录, 请先登录");
            }
            User user = (User)session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("尚未登录, 请先登录");
            }
            //2.查看是否是管理员
            if (user.getIsAdmin() == 0) {
                throw new OrderSystemException("你不是管理员, 不能修改菜的价格");
            }
            //3.获取到dishId和newPrice
            String dishIdStr = req.getParameter("dishId");
            String priceStr = req.getParameter("price");
            if (dishIdStr == null || priceStr == null) {
                throw new OrderSystemException("修改的菜品不存在");
            }
            int dishId = Integer.parseInt(dishIdStr);
            int price = Integer.parseInt(priceStr);
            //4.修改数据库的值
            DishDao dishDao = new DishDao();
            dishDao.update(dishId, price);
            //5.构造json对象
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
