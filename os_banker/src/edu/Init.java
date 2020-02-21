package edu;

import java.util.Scanner;

public class Init {

        private int a;// 系统共有a个进程
        private int b;// 共有b类资源

        private int Max[][];                // 最大需求矩阵
        private int Allocation[][];         // 已分配矩阵
        private int Need[][];               // 需求矩阵
        private int Available[];            // 可用资源向量

        private String processName[];       // 进程名
        private String resourceName[];      // 资源名

        private int Work[];                 // 可提供的各类资源数目
        private boolean Finish[];           // 判断是否有足够资源分配给进程

        private int sumAva[];               //各类资源总数,等于All+Ava

    //构造函数（进行初始化）
    public Init(int a, int b) {
        this.a = a;
        this.b = b;
        Available = new int[b];
        Max = new int[a][b];
        Allocation = new int[a][b];
        Need = new int[a][b];
        Work = new int[b];
        Finish = new boolean[a];
        resourceName = new String[b];
        processName = new String[a];
        sumAva = new int[b];
    }

       // 创建实例
    public void in() {
        Scanner s = new Scanner(System.in);
        //各进程最大资源需求情况
        System.out.println("请输入"+a+"个进程的最大资源需求情况：");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                Max[i][j] = s.nextInt();
            }
        }

        //各进程已分配情况
        System.out.println("请输入"+a+"个进程已分配资源情况：");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                Allocation[i][j] = s.nextInt();
                sumAva[j]+=Allocation[i][j];
            }
        }
        //各资源的可用情况
        System.out.println("请输入"+b+"个资源的可用资源情况：");
        for (int i = 0; i < b; i++) {
            Available[i] = s.nextInt();
            sumAva[i]+=Available[i];
        }
        //输入n个进程的进程名
        System.out.println("请输入" + a + "个进程的进程名：");
        for (int i = 0; i < a; i++) {
            processName[i] = s.next();
        }
        //输入m个资源的资源名
        System.out.println("请输入" + b + "个资源的资源名：");
        for (int i = 0; i < b; i++) {
            resourceName[i] = s.next();
        }
        // 计算  Need = Max - All
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                Need[i][j] = Max[i][j] - Allocation[i][j];
            }
        }
    }
    // 打印
    public void out() {
        System.out.println("此时系统的进程的资源情况");
        printKong();
        System.out.print(" ");
        System.out.print(" Max" );
        printKong();
        System.out.print(" ");
        System.out.print(" All");
        printKong();
        System.out.print(" Need");
        printKong();
        System.out.print(" ");
        System.out.print(" Ava");
        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < 4; i++) {
                System.out.print("  ");
            for (int j = 0; j < b; j++) {
                System.out.print(resourceName[j] + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < a; i++) {
            System.out.print(processName[i] + "  ");
            for (int j = 0; j < b; j++) {
                System.out.print(Max[i][j] + " ");
            }
            System.out.print("  ");
            for (int j = 0; j < b; j++) {
                System.out.print(Allocation[i][j] + " ");
            }
            System.out.print("  ");
            for (int j = 0; j < b; j++) {
                System.out.print(Need[i][j] + " ");
            }
            if (i == 0) {
                System.out.print("  ");
                for (int j = 0; j < b; j++) {
                    System.out.print(Available[j] + " ");
                }
            }
            System.out.println();
        }
    }
    //打印空格
    public void printKong() {
        for (int i = 0; i < b; i++)
            System.out.print(" ");
    }
    public int[] getAvailable()
    {
        return Available;
    }

    public void setAvailable(int[] available) {
        Available = available;
    }

    public int[][] getMax() {
        return Max;
    }

    public void setMax(int[][] max) {
        Max = max;
    }

    public int[][] getAllocation() {

        return Allocation;
    }

    public void setAllocation(int[][] allocation) {
        Allocation = allocation;
    }

    public int[][] getNeed() {
        return Need;
    }

    public void setNeed(int[][] need) {
        Need = need;
    }

    public String[] getProcessName() {
        return processName;
    }

    public void setProcessName(String[] processName) {
        this.processName = processName;
    }

    public String[] getResourceName() {
        return resourceName;
    }

    public void setResourceName(String[] resourceName) {
        this.resourceName = resourceName;
    }

    public int[] getWork() {
        return Work;
    }

    public void setWork(int[] work) {
        Work = work;
    }

    public boolean[] getFinish() {
        return Finish;
    }

    public void setFinish(boolean[] finish) {
        Finish = finish;
    }
}