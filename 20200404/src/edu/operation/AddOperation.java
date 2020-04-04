package edu.operation;

import edu.book.Book;
import edu.book.BookList;

import java.util.Scanner;

public class AddOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("增加书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入新增的书名:");
        String name = scanner.nextLine();
        System.out.println("请输入书的作者:");
        String author = scanner.nextLine();
        System.out.println("请输入书的价格:");
        int price = scanner.nextInt();
        System.out.println("请输入图书的类型:");
        String type = scanner.next();

        Book book = new Book(name,author,price,type,false);

        int pos = bookList.getUserSize();
        bookList.setBooks(pos,book);
        bookList.setUserSize(pos+1);
        System.out.println("新增图书成功！");
    }
}
