package edu.集合.Test;

import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("aaa",new Student(124,"dai",'女'));
        m.put("bbb",new Student(125,"hu",'女'));

        System.out.println(m.get("aaa"));  //通过键取值

          Set s=  m.entrySet();   //entrySet()是键值对同时取
           Iterator iterator = s.iterator();
           while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();  //转化为entry对象 同时取出键和值
               System.out.println(entry.getKey() + ":" + entry.getValue());
           }

          Collection c = m.values(); //取出所有的值
          Iterator i = c.iterator();
            while(i.hasNext()){
             System.out.println(i.next());
            }


           Set ss  =  m.keySet();
            Iterator iter = ss.iterator();
            while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
