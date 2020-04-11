package edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class TestDemo {
    public static void main(String[] args) {
        //实例化一个Collection对象,Collection 是一个接口,必须要new 一个对应的类作为实例才可以
        Collection<String> collection = new ArrayList <>();
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
        System.out.println("*********");


        collection.add("hello");
        collection.add("zzn");
        collection.add("drr");
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());

        //String也是继承Object ,array看似是一个Object 数组,其实是String数组
        System.out.println("***********");
        Object[] array = collection.toArray();
        System.out.println(Arrays.toString(array));
        System.out.println(collection);

        //for each 遍历collection
        //比较简单的遍历方式,用while 和 for都需要用到迭代器
        System.out.println("**********");
        for (String s: collection) {
            System.out.println(s);
        }

        //判断元素是否存在(按值比较)
        System.out.println("**********");
        boolean ret = collection.contains("zzn");
        System.out.println(ret);

        //删除指定元素
        System.out.println("*********");
        collection.remove("drr");
        for (String s: collection) {
            System.out.println(s);
        }

        //clear 清空集合
        collection.clear();;
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());




    }
}
