package edu.operation;

import edu.book.Book;
import edu.book.BookList;

import java.util.Scanner;

public class DelOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("删除书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的书名:");
        String name = scanner.nextLine();
        int count = bookList.getUserSize();
        for (int i = 0; i < count ; i++) {
            if(bookList.getBooks(i).getName().equals(name)){
                for(int j = i; j < count - 1; j++){
                    Book book = bookList.getBooks(j+1);
                    bookList.setBooks(j,book);
                }
                bookList.setUserSize(count-1);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("没有此书");
    }
}
