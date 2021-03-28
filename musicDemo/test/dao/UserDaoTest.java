package dao;

import entity.User;
import org.junit.Test;


public class UserDaoTest {

    @Test
    public void addUser() {
        User user = new User();
        user.setUsername("hqq");
        user.setPassword("123");
        UserDao userDao = new UserDao();
        userDao.addUser(user);
    }

    @Test
    public void login() {
        UserDao userDao = new UserDao();
        System.out.println(userDao.login("hqq"));
    }


    @Test
    public void findByName() {
        UserDao userDao = new UserDao();
        System.out.println(userDao.findByName("hm"));
    }
}