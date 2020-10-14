package edu.nowcoder;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main2 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int buyCoke(int m, int a, int b, int c, int x) {
        int count = 0;
        int aa = a * 10;
        int bb = b * 50;
        int cc = c * 100;
        while (m > 0) {
            if (x > cc) {
                count += c;
                x = x - cc;
                if (x > bb) {
                    count += b;
                    x = x - bb;
                }
                count += x / 10;
            } else {
                if (cc % x == 0) {
                    count++;
                    cc = cc - x;
                } else {
                    cc = cc - (x / 100 + 1) * 100;
                    if ((cc - x) % 50 == 0) {
                        bb += cc - x;
                    } else {
                        bb += ((cc - x) / 50) * 50;
                        aa += (cc - x) % 50;
                    }
                }
            }
            m--;
        }
        return count;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        int _a;
        _a = Integer.parseInt(in.nextLine().trim());

        int _b;
        _b = Integer.parseInt(in.nextLine().trim());

        int _c;
        _c = Integer.parseInt(in.nextLine().trim());

        int _x;
        _x = Integer.parseInt(in.nextLine().trim());

        res = buyCoke(_m, _a, _b, _c, _x);
        System.out.println(String.valueOf(res));

    }
}