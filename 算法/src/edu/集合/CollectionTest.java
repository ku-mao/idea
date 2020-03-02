package edu.集合;

import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Collection集合的规范
 * Set继承Collection接口，无序，里面不能放重复元素
 * List继承Collection接口，有索引，里面可放重复元素
 */
public class CollectionTest {
    public static void main(String[] args) {
        Collection c = new ArrayList();
         c.add("Hello");
         c.add("Hello");
         c.add("World");
         c.add("!");
        Iterator iterator = c.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("************************");
        c = new LinkedList();
        c.add("Hello");
        c.add("Hello");
        c.add("World");
        c.add("!");
        iterator = c.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("*************************");
        /**
         * HashSet 没索引 实现Set接口
         */
        c = new HashSet();
        c.add("Hello");
        c.add("Hello");
        c.add("World");
        c.add("!");
         iterator = c.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("****************************");

        /**
         * TreeSet 没索引 实现Set接口  但是会按字符排序
         */
        c = new TreeSet();
        c.add("Hello");
        c.add("Hello");
        c.add("World");
        c.add("!");
        iterator = c.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
