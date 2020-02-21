package edu;

import java.util.Scanner;

public class Requset {
    private int[] req = null;// 存请求的资源数
    private String index = null ;// 请求资源进程的编号
    // 用于试分配
    private int[][] All = null;
    private int[][] N = null;
    private int[] Ava = null;

    Scanner s = new Scanner(System.in);

    // 判断输入的请求编号是否合法
    public boolean isLegNum(String index, int a) {
        String str = "[0-9]+";
        return index.matches(str)&&Integer.parseInt(index) >= 0 && Integer.parseInt(index) < a;
    }


    // 请求资源情况
    public void request(int a, int b) {
        req = new int[b];
        System.out.println("请输入请求的资源编号：");
        index = s.next();
        while (!isLegNum(index, a)) {
            System.out.println("请重新输入请求的正整数的资源编号：[0-" + (a-1) + "]");
            index = s.next();
        }
        System.out.println("请输入" + b + "个资源请求数目：");
        for (int i = 0; i < b; i++) {
            req[i] = s.nextInt();
        }
    }



    //request合法性检查


    // 是否合法请求 request<=need
    public boolean isLegalIn(String index, int req[], int Need[][]) {
        boolean flag = true;
        for (int j = 0; j < req.length; j++) {
            if (req[j] > Need[Integer.parseInt(index)][j]) {
                flag = false;
                System.out.println("输入不合法！！大于需求数了！!");
                return flag;
            }
        }
        return flag;
    }

    //  request<=available
    public boolean isLegalRes(int req[], int Available[]) {
        boolean flag = true;
        for (int j = 0; j < req.length; j++) {
            if (req[j] > Available[j]) {
                flag = false;
                System.out.println("可用资源不足！不可以分配！");
                return flag;
            }
        }
        return flag;
    }

    //试分配
    public void tryAll(String index, int req[], int Allocation[][], int Need[][], int Available[]) {
        //先记录原始值,因为不安全时需要回退
        int n = Allocation.length;    //n是进程数
        int m =Allocation[0].length;   //m是资源数
        All = new int[n][m];
        N = new int[n][m];
        Ava = new int[m];
        //先记录原始值,因为不安全时需要回退分配
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                All[i][j] = Allocation[i][j];
                N[i][j] = Need[i][j];
            }
        }
        for(int i = 0;i<m;i++) {
            Ava[i] = Available[i];
        }
        int index1= Integer.parseInt(index);
        for (int i = 0; i < req.length; i++) {
            All[index1][i] += req[i]; //all=all+req
            N[index1][i] -= req[i];//need = need-req
            Ava[i] -= req[i];//ava = ava-req
        }
    }


    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public int[][] getAll() {
        return All;
    }

    public void setAll(int[][] all) {
        All = all;
    }

    public int[][] getN() {
        return N;
    }

    public void setN(int[][] n) {
        N = n;
    }

    public int[] getAva() {
        return Ava;
    }

    public void setAva(int[] ava) {
        Ava = ava;
    }

    public int[] getReq() {
        return req;
    }

    public void setReq(int[] req) {
        this.req = req;
    }
}
