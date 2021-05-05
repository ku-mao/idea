package edu.day;

import java.util.ArrayList;
import java.util.Collections;

public class QuanPaiLie {
    public static void main(String[] args) {
       String s = "abc";
       ArrayList<String> str = permutation(s);
       for (String s1 : str) {
           System.out.print(s1 +" ");
       }
    }
    private static ArrayList<String> permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null) {
            return list;
        }
        help(str.toCharArray(), 0, list);
        Collections.sort(list);
        return list;
    }
    private static void Swap(char[] str, int i, int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
    private static boolean  IsExist(ArrayList<String> result, char[] str){
        return result.contains(String.valueOf(str));
    }
    private static void help(char[] ch, int start, ArrayList<String> list) {
        if (start == ch.length - 1) {
            if(!IsExist(list, ch)){
                list.add(new String(ch));
            }
            return;
        }
        for (int i = start; i < ch.length; i++) {
            Swap(ch, start, i);
            help(ch, start+1, list);
            Swap(ch, start, i);
        }
    }
}
