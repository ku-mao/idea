package 正则表达式;

import org.junit.Test;

public class RegexTest {

/*
 *  match()方法返回的是Boolean值
 */
    @Test
    public void test1(){
        String regx = "hello";
        String str = "Hello";
        System.out.println(str.matches(regx));//false
        str = "hello12";
        System.out.println(str.matches(regx));//false
        str = "hello";
        System.out.println(str.matches(regx));//true
    }

     //[]方括号表示在括号里面的只匹配一个
    //[^ ] 是不匹配
     @Test
    public void test2(){
        String regx = "[a-zA-Z0-9]ello";
        String str = "Hello";
        System.out.println(str.matches(regx));//true
        regx = "[^0-9]{1,5}";
        str = "dai";
        System.out.println(str.matches(regx));//true
        str = "9d";
        System.out.println(str.matches(regx));//false
    }


    //+匹配前面的子表达式一次或多次。例如，'zo+' 能匹配 "zo" 以及 "zoo"，但不能匹配 "z"。+ 等价于 {1,}。
    @Test
    public void test3(){
        System.out.println("重复次数*************************************************************************************************");
        String regx = "[a-zA-Z0-9]+ello";
        String str = "HHHello";
        System.out.println(str.matches(regx));//true
    }

    //*	匹配前面的子表达式零次或多次。例如，zo* 能匹配 "z" 以及 "zoo"。* 等价于{0,}。
    @Test
    public void test4(){
        String regx = "[a-zA-Z0-9]*ello";
        String str = "ello";
        System.out.println(str.matches(regx));//true
    }

    // ?匹配前面的子表达式零次或一次。
    // 例如，"do(es)?" 可以匹配 "do" 、 "does" 中的 "does" 、 "doxy" 中的 "do" 。? 等价于 {0,1}。
    @Test
    public void test5(){
        String regx = "[a-zA-Z0-9]?ello";
        String str = "ello";
        System.out.println(str.matches(regx));//true
    }

    //{n}	n 是一个非负整数。匹配确定的 n 次。
    // 例如，'o{2}' 不能匹配 "Bob" 中的 'o'，但是能匹配 "food" 中的两个 o。
    @Test
    public void test6(){
        String regx = "[a-zA-Z0-9]{2}ello";
        String str = "Hello";
        System.out.println(str.matches(regx));//false
        str = "Hnello";
        System.out.println(str.matches(regx));//true
    }

    /*
     * {n,}	n 是一个非负整数。至少匹配n 次。
     *     例如，'o{2,}' 不能匹配 "Bob" 中的 'o'，但能匹配 "foooood" 中的所有 o。'o{1,}'
     *     等价于 'o+'。'o{0,}' 则等价于 'o*'。
     */
    @Test
    public void test7(){
        String regx = "o{1,}";
        String str = "oo";
        System.out.println(str.matches(regx));//true
        str = "boy";
        System.out.println(str.matches(regx));//false
    }

    /*
     * {n,m}m 和 n 均为非负整数，其中n <= m。最少匹配 n 次且最多匹配 m 次。
     *      例如，"o{1,3}" 将匹配 "fooooood" 中的前三个 o。'o{0,1}' 等价于 'o?'。
     *     请注意在逗号和两个数之间不能有空格。
     */
    @Test
    public void test8(){
        String regx = "fo{1,3}d";
        String str = "food";
        System.out.println(str.matches(regx));//true
        str = "foooooood";
        System.out.println(str.matches(regx));//false
    }


    /*
     * 简写
     * \d 匹配数字[0-9]
     * \D 不匹配数字[^0-9]
     * \w 匹配字符包括下划线[0-9a-zA-Z_]
     * \W 不匹配字符[^0-9a-zA-Z_]
     * \f 匹配一个换页符
     * \n 匹配一个换行符
     * \r 匹配一个回车符
     * \s 匹配任何不可见字符，包括空格、制表符、换页符等等。等价于[ \f\n\r\t\v]。
     * \S 匹配任何可见字符。等价于[^ \f\n\r\t\v]
     */
    @Test
    public void test9() {
        String regx = "\\d{2,}";
        String str = "987";
        System.out.println(str.matches(regx));//true
        str = "9dd";
        System.out.println(str.matches(regx));//false
        regx = "\\D{2,}";
         str = "asd";
        System.out.println(str.matches(regx));//true
        str = "9dd";
        System.out.println(str.matches(regx));//false
        regx = "\\w{2,}";
        str = "asd";
        System.out.println(str.matches(regx));//true
        str = "@dd";
        System.out.println(str.matches(regx));//false
         regx = "\\W{2,}";
        str = "@%@";
        System.out.println(str.matches(regx));//true
        str = "9dd";
        System.out.println(str.matches(regx));//false
    }

   /*
    * 匹配特殊字符
    * 转义符\ 在字符串里\\ 代表\
    * 在匹配规则里面 \\ 代表转义符
    * \/ 匹配/
    * \[ 匹配 [
    * \] 匹配 ]
    */
    @Test
    public void test10(){
        String regx = "\\\\\\/\\[\\]";
        String str = "\\/[]";
        System.out.println(str.matches(regx));//true
    }

    /**
     * 分组、或
     * 分组用()
     */
    @Test
    public void test11(){
        String regx = "(\\(0\\d{2}\\)|0\\d{2})( |_|-)\\d{7,8}";
        String str = "029 23345623";
        System.out.println(str.matches(regx));//true
        str = "029-23345623";
        System.out.println(str.matches(regx));//true
        str = "029_23345623";
        System.out.println(str.matches(regx));//true

    }

    /**
     * 定位符
     * \b 匹配一个单词的边界，也就是指单词和空格间的位置
     * 例如，“er\b”可以匹配“never”中的“er”，但不能匹配“verb”中的“er”；
     * “\b1_”可以匹配“1_23”中的“1_”，但不能匹配“21_3”中的“1_”。
     * \B 匹配非单词边界。“er\B”能匹配“verb”中的“er”，但不能匹配“never”中的“er”
     * ^  匹配输入字符串开始的位置
     * $  匹配输入字符串结尾的位置
     * "^Chapter [1-9][0-9]{0,1}$"
     */


}
