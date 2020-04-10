package edu;

import java.util.Arrays;

public class TestDemo2 {
    /**
     * StringBuilder
     * 字符串翻转
     * 删除指定范围数据
     * 插入
     * @param args
     */
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello zzn");
       // System.out.println(sb.reverse());
       // System.out.println(sb.delete(5,8));
        System.out.println(sb.insert(0, "你好 "));

    }


    /**
     *截取子串substring
     */
    public static void main3(String[] args) {
        String str = "hello zzn";
        //前闭后开截取
        System.out.println(str.substring(3,5));
        //从3开始到结束
        System.out.println(str.substring(3));
    }


    /**
     * split
     */
    public static void main2(String[] args) {
        String str1 = "aaa,bbb,ccc";
        String[] result = str1.split(",");
        System.out.println(Arrays.toString(result));//[aaa, bbb, ccc]
        String str2 = "aaa,bbb,,ccc";
        String[] result2 = str2.split(",");
        System.out.println(Arrays.toString(result2));//[aaa, bbb, , ccc]

        //.在正则表达式具有特定含义,所以需要转义
        //Java代码中字符串不能直接写\ ,需要\\表示一个文本\
        String ip = "192.168.1.1";
        String[] res = ip.split("\\.");
        System.out.println(Arrays.toString(res));

        String mes = "name=张三&age=18";
        String[] tmp = mes.split("&");
        for(String s1 : tmp) {
            String[] tmp2 = s1.split("=");
            System.out.println(tmp2[0] + ":" + tmp2[1]);
        }

    }


    /**
     *
     * 判断子串
     * @param args
     */
    public static void main1(String[] args) {
        String str = "hello world world";
        String str2 = "wo";

        //通过contains()方法可以判断是否包含关系
        System.out.println(str.contains(str2));

        //indexOf()判断是否包含子串,还可返回子串的所在位置下标
        //存在多组子串时,返回最左侧下标
        System.out.println(str.indexOf(str2));

        //存在多组子串时,返回最右侧下标
        System.out.println(str.lastIndexOf(str2));

        //startWith,endWith 返回boolean类型
        System.out.println(str.startsWith("he"));
        System.out.println(str.endsWith("ld"));

        //replaceAll/replaceFirst 都是返回一个新串
        String res = str.replaceAll("world","zzn");
        System.out.println(str);
        System.out.println(res);
    }
}
