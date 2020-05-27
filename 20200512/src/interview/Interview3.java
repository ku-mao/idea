package interview;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Interview3 {
    public static void main(String[] args) {
        //循环读入两个字符串，第一个字符串是预期输出的内容，第二个字符串是实际输出的内容
        //把读入的两个字符串全部转为大写(根据题目的输出示例)
        //题目中的主要任务是判断预期输出的那些字符在实际输出的字符串中没有存在

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String except = scanner.next();
            String actual = scanner.next();
            //把2个字符串都转为大写
            except = except.toUpperCase();
            actual = actual.toUpperCase();
            Set<Character> actualSet = new HashSet <>();
            for (int i = 0; i < actual.length(); i++) {
                actualSet.add(actual.charAt(i));
            }
            Set<Character> resultSet = new HashSet <>();
            for (int i = 0; i < except.length(); i++) {
                Character c = except.charAt(i);
                if(actualSet.contains(c)) {
                    continue;
                }
                if(resultSet.contains(c)) {
                    continue;
                }
                System.out.print(c);
                resultSet.add(c);
            }
        }
    }
}
