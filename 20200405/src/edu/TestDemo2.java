package edu;

import java.util.Scanner;

class UserException extends RuntimeException {
    public UserException(String message) {
        super(message);
    }
}
class PasswordException extends RuntimeException {
    public PasswordException(String message) {
        super(message);
    }
}

public class TestDemo2 {
    private static String userName = "admin";
    private static String password = "123456";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        try {
            login(name, password);
        } catch (UserException userError) {
            userError.printStackTrace();
        } catch (PasswordException passwordError) {
            passwordError.printStackTrace();
        } finally {
            scanner.close();
        }
    }
    public static void login(String userName, String password) throws UserException,
            PasswordException {
        if (!TestDemo2.userName.equals(userName)) {
            throw new UserException("用户名错误");
        }
        if (!TestDemo2.password.equals(password)) {
            throw new PasswordException("密码错误");
        }
        System.out.println("登陆成功");
    }
}
