package edu.nowcoder;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 某工厂有n个独立的作业，由m台相同的机器进行加工处理。
 * 作业i所需的加工时间为ti，任何作业在被处理时不能中断，也不能进行拆分处理。
 * 现厂长请你给他写一个程序：算出n个作业由m台机器加工处理的最短时间
 * 输入
 * 第一行T（1<T<100)表示有T组测试数据。每组测试数据的第一行分别是整数n, m，接下来的一行是n个整数ti。
 * 输出
 * 所需的最短时间
 */
public class 多机调度问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] workTime = new int[n];
            for (int i = 0; i < n; i++) {
                workTime[i] = scanner.nextInt();
            }
            System.out.println(getMinTime(workTime, m));
        }
    }
    //m台机器, workTime 任务的运行时长
    private static int getMinTime(int[] workTime, int m) {
        //先针对任务的运行时间进行从高到低的排序
        Arrays.sort(workTime);
        int n = workTime.length;
        int[] machines = new int[m];//存储当前机器运行完当前任务的时间
        if (n <= m) {
            return workTime[n - 1];
        }
        //给每一个任务分配机器
        for (int i = n - 1; i >= 0; --i) {
            //选择最小的机器
            int flag = 0;
            int time = machines[flag];
            //从剩下的机器里选择最早结束的
            for (int j = 1; j < m; j++) {
                if (time > machines[j]) {
                    flag = j;
                    time = machines[j];
                }
            }
            //把当前的任务交给最早完成的机器完成
            machines[flag] += workTime[i];
        }
        Arrays.sort(machines);
        return machines[m - 1];
    }
}
