package edu.main;

import edu.book.BookList;
import edu.user.AdminUser;
import edu.user.NormalUser;
import edu.user.User;

import java.util.Scanner;

public class Main {
    public static User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的名字:");
        String name = scanner.nextLine();
        System.out.println("Hello  " + name +"  欢迎来到图书系统");
        System.out.println("请选择你的身份: 1.管理员 0.普通用户");
        int result = scanner.nextInt();
        if(result == 1) {
            return new AdminUser();
        } else {
           return new NormalUser();
        }
    }
    public static void main(String[] args) {
        //准备
        BookList bookList = new BookList();

        //2.登录
        User user = login();
        while (true) {
            int choice = user.menu();
            //3.选择要进行的操作
            user.doOperation(choice,bookList);
        }

    }
}
