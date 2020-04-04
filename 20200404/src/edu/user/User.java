package edu.user;

import edu.book.BookList;
import edu.operation.IOperation;

abstract public class User {
    public String name;

    public IOperation[] operations ;
    public abstract int  menu();

    public void doOperation (int choice, BookList bookList) {
        operations[choice].work(bookList);
    }

}
