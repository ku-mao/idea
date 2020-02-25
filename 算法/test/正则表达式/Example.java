package 正则表达式;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    /**
     * 非贪婪匹配
     *
     *    /*这是一个主函数*/
     /**   void main(){
      *    /* 这是主函数内部*/
    /**       int a = 10 ;//声明一个变量a
     *       int b = 20 ;//声明一个变量b
     *       printf("a + b = %d", a + b);
     *   }
      *   quit
     */
    @Test
    public void test4(){
        Scanner s = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        sb.append("/*这是一个主函数*/")
          .append("void main(){")
          .append("/* 这是主函数内部*/\n")
          .append("int a = 10 ;//声明一个变量a\n")
          .append("int b = 20 ;//声明一个变量b\n")
          .append("printf(\"a + b = %d\", a + b);\n" )
          .append("}\n");
//         String temp;
//         while(!(temp = s.nextLine()).equals("quit")){
//             sb.append(temp).append("\n");
//         }
        String str = sb.toString();

        String regex1 = "\\/\\*.+?\\*\\/";
        str = str.replaceAll(regex1,"");
        regex1 = "\\/\\/.+?\\n";
        System.out.println(str.replaceAll(regex1,"\n"));
    }

    @Test
    public void test5(){
    String regex = "%.*?%";//非贪婪匹配
        String str = "%afgs% dfff %fsf% sfs%";
        System.out.println(str.replaceAll(regex,"aaa"));
        System.out.println("*****************");
        String regex1 = "%.+%";//贪婪匹配
        String str1 = "%afgs% dfff %fsf sfs%";
        System.out.println(str.replaceAll(regex1,"aaa"));
    }

    /**
     * 分组替换
     */
    @Test
    public void test6(){
       String regex = "(%)(.*?)(%)";//引号里面全部为组0($0)
        String str = "%good% %study% %oh%";
        System.out.println(str.replaceAll(regex,"$1"));//"$2"代表把组2直接拿出来
        System.out.println(str.replaceAll(regex,"$1dai$3"));
    }

    /**
     * 正则表达式里面的2个对象
     * Matcher//把匹配的字符串遍历出来
     * Pattern//模式对象  解析规则
     */
    @Test
    public void test7(){
        Pattern pattern = Pattern.compile("(%)(.*?)(%)");
        String str = "%good% %study% %oh%";
        Matcher m = pattern.matcher(str);
        while(m.find()){
           // System.out.println(m.group()+ "startIndex:" + m.start() +  ",endIndex:" + m.end());//全部输出，group默认参数为0
           // System.out.println(m.group(1)+"dai"+ m.group(3));//替换百分号中间的字符
            System.out.println(m.group(2).substring(1,2));//取出中间字符的部分输出结果为go,st,oh

        }

    }
}
