package edu;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String printArray(int[][] array) {
        String ret = "";
        for (int i= 0; i < array.length;i++) {
            int k = 0;
            for (int j = i; j >= 0 && k <= i; j--,k++) {
                ret += String.valueOf(array[k][j]);
                ret += ',';
            }
        }
        return ret;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        int _array_rows = 0;
        int _array_cols = 0;
        _array_rows = Integer.parseInt(in.nextLine().trim());
        _array_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _array = new int[_array_rows][_array_cols];
        for(int _array_i=0; _array_i<_array_rows; _array_i++) {
            for(int _array_j=0; _array_j<_array_cols; _array_j++) {
                _array[_array_i][_array_j] = in.nextInt();
            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = printArray(_array);
        System.out.println(res);
    }
}

