package edu.operation;

import edu.book.Book;
import edu.book.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要借阅的书籍:");
        String name = scanner.nextLine();

        for (int i = 0; i < bookList.getUserSize() ; i++) {
            Book book = bookList.getBooks(i);
            if(book.getName().equals(name)) {
                if(book.isBorrowed()) {
                    System.out.println("书已经被借出");
                    return;
                }
                book.setBorrowed(true);
                System.out.println("借阅成功！");
                return;
            }
        }
        System.out.println("没有这本书");
    }
}
