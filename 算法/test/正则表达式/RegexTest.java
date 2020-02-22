package 正则表达式;

import org.junit.Test;

public class RegexTest {

/*
 * \\d{11}匹配11位数字
 */
    @Test
    public void test1(){
        String regx = "\\d{11}";
        String str = "1234567898";
        System.out.println(str.matches(regx));//返回的是Boolean值
    }

    // []方括号表示在括号里面的只匹配一个
    // 表达式写在方括号里
     @Test
    public void test2(){
        String regx = "[a-zA-Z0-9]ello";
        String str = "Hello";
        System.out.println(str.matches(regx));//true
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

    

}
