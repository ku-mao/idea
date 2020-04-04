package edu.operation;

import edu.book.BookList;

public class DisplayOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("展示书籍");
        for (int i = 0; i < bookList.getUserSize() ; i++) {
            System.out.println(bookList.getBooks(i));
        }
    }
}
