package edu.nowcoder;


import java.util.HashSet;
import java.util.Set;

public class singleNumber {
    public static void main(String[] args) {
        int[] a = {1,2,2,4,5,6,1,4,5};
        System.out.println(find1(a));

        int[] b ={1,3,4,1,3,4,1,3,4,78};
        System.out.println(find2(b));
    }

    /**
     * 数组中的元素, 只有一个出现一次, 其他都出现2次 找到出现一次的元素
     * @param a
     * @return
     */
    private static int find1(int[] a) {
        int result = 0;
        for (int i = 0; i < a.length ; i++) {
            result ^= a[i];
        }
        return result;
    }

    /**
     * 只有一个元素出现一次, 其他元素都出现3次, 找到那个元素
     * @param b
     * @return
     */
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


