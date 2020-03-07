package edu;


import java.util.HashSet;
import java.util.Set;

public class singleNumber {
    public static void main(String[] args) {
        int[] a = {1,2,2,4,5,6,1,4,5};
        System.out.println(find1(a));

        int[] b ={1,3,4,1,3,4,1,3,4,78};
        System.out.println(find2(b));
    }

    private static int find1(int[] a) {
        int result = 0;
        for (int i = 0; i < a.length ; i++) {
            result ^= a[i];
        }
        return result;
    }

    private static int find2(int[] b) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int singleSum = 0;
        for(int i : b){
            sum += i;
            set.add(i);
        }
        for(int s : set){
            singleSum += s;
        }
        return (singleSum * 3 - sum )/2;
    }
}


