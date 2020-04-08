package edu;

import java.lang.reflect.Field;
import java.util.Scanner;

public class TestDemo {
    private static int compareTo(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int len = (len1 < len2) ? len1 : len2;
        int i = 0;
        while (i < len) {
            char c1 = str1.charAt(i);
            char c2= str2.charAt(i);
            if(c1  != c2) {
              return c1-c2;
            }
            i++;
        }
        return len1 -len2;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        System.out.println(compareTo(str1,str2));
    }


    public static void main9(String[] args) {
        String str1 = "haha";
        String str2 = "Haha";
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));

        System.out.println(str1.compareTo(str2));//返回差值的数字
    }


    public static void main8(String[] args) {
        char[] array = {'h', 'a', 'h', 'a'};
        String str = new String(array);
        System.out.println(str);

        //遍历字符串
        //涉及到字符串拷贝
        char[] array2 = str.toCharArray();
        for (int i = 0; i < array2.length ; i++) {
            System.out.print(array2[i] + " ");
        }
        System.out.println();
        System.out.println("*******");
        //这种方法更好
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
    }



    public static void main7(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str = "hehe";
        //需要根据"value" 这个名字找到str 中内部存储的value数组
        //1.获取到String 对象的图纸(进一步了解String里面的细节)
       Field field = String.class.getDeclaredField("value");
       field.setAccessible(true);
       //2.根据图纸找到str 里面的value数组
        char[] value = (char[])field.get(str);

        //然后修改这个数组的内容即可
        value[0] = 'a';
        System.out.println(str);
    }




    public static void main6(String[] args) {
        String str = "hehe";
        str = "haha";
        System.out.println(str);

    }


    /**
     * 字符串常量池
     */
    public static void main5(String[] args) {
        String str1 = "hehe";
        //intern()方法可以主动去池子中查找,看看当前这个String 是否在池中存在
        //如果在池中不存在,则把这个String加入到池中
        //如果存在,就可舍弃当前对象,直接获取到池中的对应对象的引用
        String str2 = new String("hehe").intern();
        System.out.println(str1 == str2);
    }

    public static void main4(String[] args) {
        String str1 = "hehe";
        String str2 = "hehe";
        String str3 = "hehe";
        String str4 = "hehe";
        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
        System.out.println(str3 == str4);
    }


    /**
     * 面试问题
     * @param args
     */
    public static void main3(String[] args) {
        String str1 = null;
      //  System.out.println(str1.equals("hehe"));
        System.out.println("hehe".equals(str1));//最好这样写
    }

    /**
     * 字符串比较
     * @param args
     */
    public static void main2(String[] args) {
        String str1 = "hehe";
        String str2 = new String("hehe");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
    }

    public static void main1(String[] args) {
        //创建String对象
        String str1 = "hehe";
        String str2 = new String("hehe");
        char[] buffer = {'a', 'b', 'c'};
        String str3 = new String(buffer);
    }

}
