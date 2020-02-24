package 正则表达式;

import org.junit.Test;

import java.util.Arrays;

public class Example {

    /**
     * 测试一个邮件的格式
     * 1. 包含@
     * 2. @前面要有一个以上单词字符
     * 3. @后面要有一个 . 符号
     * 4. @和 . 之间要有一个以上单词字符
     * 5. . 后面还可能出现一个以上单词字符
     * 6. 后面还可能重复出现若干 . 单词字符
     * 例如 bbb@dd.com.cn  1335446898@qq.com.cn
     */
    @Test
    public void test1(){
    String regex = "\\w+@\\w+(\\.\\w+)+";
    String str = "bbb@dd.com.cn";
        System.out.println(str.matches(regex));
    }

    @Test
    public void test2(){
        int [] a = {24,5,67,342,56};
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * replaceAll()
     */
    @Test
    public void test3(){
        String str = "Hello-World !";
        System.out.println(str.replace("-"," "));
        //正则表达式
        str = "Hello-World , Hi_Everyone|";
        System.out.println(str.replaceAll("-|,|_|\\|"," "));
    }

    
}
