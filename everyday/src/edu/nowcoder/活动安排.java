package edu.nowcoder;

import com.sun.deploy.util.SyncAccess;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 有n个需要在同一天使用同一个教室的活动a1, a2, …, an，教室同一时刻只能由一个活动使用。
 * 每个活动a[i]都有一个开始时间s[i]和结束时间f[i]。
 * 一旦被选择后，活动a[i]就占据半开时间区间[s[i],f[i])。
 * 如果[s[i],f[i])和[s[j],f[j])互不重叠，a[i]和a[j]两个活动就可以被安排在这一天。
 * 求使得尽量多的活动能不冲突的举行的最大数量。
 */
public class 活动安排 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入活动的个数: ");
        int n = scanner.nextInt();
        int[][] act = new int[n][2];
        for (int i = 0; i < n; i++) {
            act[i][0] = scanner.nextInt();
            act[i][1] = scanner.nextInt();
        }
        System.out.println(actNum(act));
    }
    private static int actNum(int[][] act) {
        //按照活动截止时间从小到大排序
        Arrays.sort(act, new Comparator <int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int num = 1;
        int i = 0;
        for (int j = 1; j < act.length; j++) {
            if (act[i][1] <= act[j][0]) {
                num++;
                i = j;
            }
        }
        return num;
    }
}
