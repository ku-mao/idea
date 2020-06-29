package edu.nowcoder;

import java.util.*;
public class 人民币转换 {
    public static Map<Integer, String> map = new HashMap<>();
    public static void main (String[] args) {
        map.put(1, "壹");
        map.put(2, "贰");
        map.put(3, "叁");
        map.put(4, "肆");
        map.put(5, "伍");
        map.put(6, "陆");
        map.put(7, "柒");
        map.put(8, "捌");
        map.put(9, "玖");
        map.put(0, "零");
        String[] a = {"元", "万","亿"};
        String[] b = {"", "拾", "佰", "仟"};

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split("\\.");
        StringBuffer res = new StringBuffer("");
        int length = s[0].length();
        int n = Integer.parseInt(s[0]);
        int r = Integer.parseInt(s[1]);
        if (r == 0) {
            res.insert(0,"整");
        } else {
            res.insert(0, convert(r));
        }
        int j = 0;
        int count = 0;//计算中间0的个数
        int num = 0;
        int len = 0;
        while (true) {
            if ( n == 0) {
                break;
            }
            if (length > 4) {
                len = 4;
            } else if (length > 0){
                len = length;
            } else {
                break;
            }
            res.insert(0, a[j]);
            for (int i = 0; i < len; i++) {
                num = n % 10;
                if (num == 0) {
                    if (j == 0 && i == 0) {
                        count++;
                        continue;
                    } else if (count == 0) {
                        res.insert(0, "零");
                        count++;
                    } else {
                        continue;
                    }
                } else {
                    count = 0;
                    if (num == 1 && i == 1) {
                        res.insert(0, b[i]);
                    } else {
                        res.insert(0, map.get(num) + b[i]);
                    }
                }
                n = n / 10;
            }
            j++;
            length = length - 4;
        }
        res.insert(0, "人民币");
        System.out.println(res);
    }
    private static StringBuffer convert(int n) {
        StringBuffer sb = new StringBuffer("");
        int i = n % 10;
        if (i != 0) {
            sb.insert(0, map.get(i) + "分");
        }
        n = n / 10;
        i = n % 10;
        if (i != 0) {
            sb.insert(0, map.get(i) + "角");
        }
        return sb;
    }
}
