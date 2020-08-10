package model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Order {
    private int orderId;
    private int userId;
    private Timestamp time;
    private int isDone;
    private ArrayList<Dish> dishes;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getIsDone() {
        return isDone;
    }

    public void setIsDone(int isDone) {
        this.isDone = isDone;
    }

    public ArrayList <Dish> getDishes() {
        return dishes;
    }

    public void setDishes(ArrayList <Dish> dishes) {
        this.dishes = dishes;
    }
}
