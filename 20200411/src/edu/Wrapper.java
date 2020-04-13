package edu;

public class Wrapper {
    public static void main(String[] args) {
        //内置对象 转换为 包装类(装箱)
//        Integer i = Integer.valueOf(10);
//        Integer i2 = new Integer(10);
        Integer i = 10;//自动装箱

//        //包装类 转换为 内置类型 (拆箱)
//        int j = i.intValue();
        int j = i;//自动拆箱
    }
}
