package edu.user;

import edu.operation.*;

import java.util.Scanner;

public class AdminUser extends User {

    public AdminUser () {
        this.operations = new IOperation[] {
                new ExitOperation(),
                new FindOperation(),
                new DelOperation(),
                new AddOperation(),
                new DisplayOperation()
        };

    }
    @Override
    public int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.查找书籍");
        System.out.println("2.删除书籍");
        System.out.println("3.增加书籍");
        System.out.println("4.打印书籍");
        System.out.println("0.退出系统");
        int choice = scanner.nextInt();
        return choice;
    }
}
