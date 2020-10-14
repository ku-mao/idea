//package edu.nowcoder;
//
//import java.util.Scanner;
//
//public class Main4 {
//
//
//    /*请完成下面这个函数，实现题目要求的功能
//    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
//    ******************************开始写代码******************************/
//    static int validateArrayUsages(String[] lines) {
//        for (int i = 0; i < lines.length; i++) {
//
//        }
//
//    }
//    /******************************结束写代码******************************/
//
//
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int res;
//
//        int _lines_size = 0;
//        _lines_size = Integer.parseInt(in.nextLine().trim());
//        String[] _lines = new String[_lines_size];
//        String _lines_item;
//        for(int _lines_i = 0; _lines_i < _lines_size; _lines_i++) {
//            try {
//                _lines_item = in.nextLine();
//            } catch (Exception e) {
//                _lines_item = null;
//            }
//            _lines[_lines_i] = _lines_item;
//        }
//
//        res = validateArrayUsages(_lines);
//        System.out.println(String.valueOf(res));
//
//    }
//}