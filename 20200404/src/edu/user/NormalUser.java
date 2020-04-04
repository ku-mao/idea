package edu.user;

import edu.operation.*;

import java.util.Scanner;

public class NormalUser extends User{
    public NormalUser () {
        this.operations = new IOperation[] {
                new ExitOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation(),
                new DisplayOperation()
        };
    }

    @Override
    public int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.查找书籍");
        System.out.println("2.借阅书籍");
        System.out.println("3.归还书籍");
        System.out.println("4.打印书籍");
        System.out.println("0.退出系统");
        int choice = scanner.nextInt();
        return choice;
    }
}
