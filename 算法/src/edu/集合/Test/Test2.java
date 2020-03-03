package edu.集合.Test;

import java.util.Iterator;
import java.util.TreeSet;

public class Test2 {
    public static void main(String[] args) {
        TreeSet t = new TreeSet();
        t.add(10);
        t.add(6);
        t.add(78);
        t.add(9);

        Iterator iterator = t.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

     /**
      *
      * 当添加的对象需要排序时，不知道怎么比较的时候要自己实现Comparable接口，重写里面的方法
      */
        t = new TreeSet();
        t.add(new Student(9,"dai",'女'));
        t.add(new Student(10,"hu",'女'));
        t.add(new Student(13,"li",'女'));

         iterator = t.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
