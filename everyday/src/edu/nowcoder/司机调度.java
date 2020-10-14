package edu.nowcoder;

import java.util.ArrayList;
import java.util.Scanner;

public class 司机调度 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> money = new ArrayList <>();
        while (cin.hasNextInt()) {
            int incomeOfA = cin.nextInt();
            int incomeOfB = cin.nextInt();
            //Start coding -- Input Data
            ArrayList<Integer> list = new ArrayList <>();
            list.add(incomeOfA);
            list.add(incomeOfB);
            money.add(new ArrayList <>(list));
        }
        if (money.size() % 2 != 0) {
            System.out.println("error");
        }
        int count = 0;
        int[] arr = new int[money.size()];
        for (int i = 0; i < money.size(); i++) {
            int ret = Math.abs(money.get(i).get(0) - money.get(i).get(1));
            arr[i] = ret;
        }
        int size = arr.length;
        while (size > 0) {
            int index = findMax(arr);
            if (money.get(index).get(0) > money.get(index).get(1)) {
                count += money.get(index).get(0);
            } else {
                count += money.get(index).get(1);
            }
            size--;
        }
        System.out.println(count);
    }
    private static int findMax(int[] arr) {
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[ret]) {
                ret = i;
            }
        }
        arr[ret] = 0;
        return ret;
    }
}
