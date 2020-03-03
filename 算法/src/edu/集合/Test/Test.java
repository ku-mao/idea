package edu.集合.Test;

import java.util.HashSet;

/**
 * java中集合判断两个对象是否相等，遵守2个规范
 * equals方法是否返回true
 * hashcode方法哈希码是否相等
 */
public class Test {
    public static void main(String[] args) {
        HashSet h = new HashSet();
        h.add("Hello");
        h.add("Hello");
        h.add("Hello");
        System.out.println(h.size());

        h = new HashSet();
        h.add(22);
        h.add(22);
        h.add(22);
        System.out.println(h.size());

        h = new HashSet();
        h.add(new Student(24,"dai",'M'));
        h.add(new Student(24,"dai",'M'));
        h.add(new Student(24,"dai",'M'));
        System.out.println(h.size());

    }
}
