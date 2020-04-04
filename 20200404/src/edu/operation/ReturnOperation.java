package edu.operation;

import edu.book.Book;
import edu.book.BookList;

import java.util.Scanner;

public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("归还书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要归还的书籍:");
        String name = scanner.nextLine();

        for (int i = 0; i < bookList.getUserSize() ; i++) {
            Book book = bookList.getBooks(i);
            if(book.getName().equals(name)) {
                book.setBorrowed(false);
                System.out.println("归还成功！");
                return;
            }
        }
        System.out.println("没有这本书");
    }
}
