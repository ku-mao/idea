package edu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class TestList {
    public List<List<Integer>> ge(int numRows) {
        List<List<Integer>> result = new ArrayList <>();
        if(numRows <= 0) {
            return result;
        }
        //第一行
        ArrayList<Integer> firstLine = new ArrayList <>();
        firstLine.add(1);
        result.add(firstLine);
        if(numRows == 1) return result;

        //处理第二行的情况
        ArrayList<Integer> secondLine = new ArrayList <>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if(numRows == 2) return result;

        //处理后面行
        for (int row = 3; row <= numRows; row++) {
            List<Integer> preLine = result.get(row - 1 - 1);
            List<Integer> curLine = new ArrayList <>();
            curLine.add(1);
            //第row行一共有row列
            for(int col = 2; col <= row - 1; col++) {
                //要计算第col列的值,需要知道上一行的col - 1列和col列
                //因为get()下标是从0开始的
                int tmp1 = preLine.get(col - 1 - 1);
                int tmp2 = preLine.get(col - 1);
                curLine.add(tmp1 + tmp2);
            }
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }



    /**
     * 匿名类
     */
    static class Test extends Object {
        @Override
        public boolean equals(Object obj) {
            return true;
        }
    }
    public static void main(String[] args) {
        //创建一个"匿名内部类"
        // 内部类指的是类的定义在某个类或方法的内部
        //匿名指的是没有创建类的名字,只知道这个类是Object的子类
        // {} 里面是这个匿名类内部的实现代码
//        Object o = new Object() {
//            @Override
//            public boolean equals(Object obj) {
//                return true;
//            }
//        };
        Object o = new Test();
    }


    /**
     * 测试List
     * @param args
     */
    public static void main1(String[] args) {
        List<String> list = new ArrayList <>();
        list.add("10");
        list.add("11");
        list.add("12");
        list.add("13");
        System.out.println(list);
        System.out.println("**********");
        System.out.println(list.get(0));
        list.set(0,"9");
        System.out.println(list);

        //截取部分内容  前闭后开
        System.out.println(list.subList(1,3));
        //重新构造一个List(这里的构造是浅拷贝)
        List<String> arrayList = new ArrayList <>(list);
        List<String> linkedList = new LinkedList <>(list);
        System.out.println("------");
        System.out.println(arrayList);
        System.out.println(linkedList);

        //基于现有的List的引用进行强制转换(向下转型) 不可以转
        //ArrayList<String> arrayList1 = (ArrayList<String>)list;
        //LinkedList<String> linkedList1 = (LinkedList<String>) list;

    }
}
