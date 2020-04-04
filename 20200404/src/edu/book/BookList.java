package edu.book;

public class BookList {

    private Book[] books;

    private  int userSize;

    public BookList () {
        this.books = new Book[10];
        this.books[0] = new Book("C语言","hh",30,"学习",false);
        this.books[1] = new Book("Java","drr",50,"学习",false);
        this.books[2] = new Book("C++","ff",40,"学习",false);
        this.userSize = 3;
    }

    public Book getBooks(int pos) {
        return books[pos];
    }

    public void setBooks(int pos,Book book) {
        this.books[pos]= book;
    }

    public int getUserSize() {
        return userSize;
    }

    public void setUserSize(int userSize) {
        this.userSize = userSize;
    }

}
