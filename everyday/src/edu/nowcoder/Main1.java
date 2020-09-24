package edu.nowcoder;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //建筑物个数
        int n = Integer.parseInt(sc.nextLine());
        int[][] buildings = new int[n][3];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            for (int j = 0; j < arr.length; j++) {
                buildings[i][j] = Integer.parseInt(arr[j]);
            }
        }

        //获取天际线，待实现
        List<List<Integer>> skyline = getSkyline(buildings);

        //输出skyline到标准输出
        for (List<Integer> point : skyline) {
            int size = point.size();
            for (int i = 0; i < size; i++) {
                System.out.print(point.get(i));
                if (i < size-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ret = new ArrayList<>();
        //todo 实现算法
        List<Integer> list = new ArrayList<>();
        list.add(buildings[0][0]);
        list.add(buildings[0][2]);
        ret.add(new ArrayList<Integer>(list));
        list.clear();
        for (int i = 1; i < buildings.length; i++) {
            if (buildings[i][0] > buildings[i - 1][0] && buildings[i][2] > buildings[i - 1][2]) {
                list.add(buildings[i][0]);
                list.add(buildings[i][2]);
                ret.add(new ArrayList<Integer>(list));
                list.clear();
            } else {
                list.add(buildings[i - 1][1]);
                list.add(buildings[i][2]);
                ret.add(new ArrayList<Integer>(list));
                list.clear();
                list.add(buildings[i][1]);
                list.add(0);
                ret.add(new ArrayList<Integer>(list));
                list.clear();
                buildings[i][0] = 0;
                buildings[i][2] = 0;
            }
        }
        return ret;
    }
}
