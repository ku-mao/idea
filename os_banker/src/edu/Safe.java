package edu;

public class Safe {
    // 初始化Work和Finish,根据Ava初始化Work,根据Need初始化Finish
    public void init(int Work[],int Available[],boolean Finish[],int Need[][]) {
        // 初始化Finish[i],又因为Need[i]确定，如果全为零则为true
        int a = Finish.length;
        int b = Work.length;
        for (int i = 0; i < a; i++) {
            int flag = 0;
            for (int j = 0; j < b; j++) {
                flag = flag | Need[i][j]; //异或运算当flag和Need[i][j]都为0的时候结果才为0
            }
            if (flag == 0) {
                Finish[i] = true;
            }
            else {
                Finish[i] = false;
            }
        }
        // 初始化Work = Available
            for (int j = 0; j < b; j++) {
                Work[j] = Available[j];
        }
    }

    // 安全性检查！！！
    public boolean safeCheck(boolean Finish[], int Need[][], int Work[], String[] processName, int Allocation[][],String[] resourceName) {
        int a = Finish.length;// a个进程
        int b = Work.length;// b类资源
        int[] abc = new int[a];
        int[][] New = new int[a][b];
        int i = 0;
        int y = 0;//数组abc的下标
        while (i < a) {
            if (Finish[i] == false) {//条件1 finish = false
                int j = 0;
                for (; j < b; j++) {//条件2 need<=work
                    if (Need[i][j] > Work[j]) {
                        i++;
                        break;// 只要有一个不满足，need不小于等于work,跳出
                    }
                }
                // 满足条件，找到后
                if (j >= b) {
                    //保存检测过程中的顺序
                    if (y < a) {
                        abc[y] = i;
                        y++;
                    }
                    Finish[i] = true;// finish = true
                    for (int k = 0; k < b; k++) {
                        New[i][k] = Work[k];
                        Work[k] += Allocation[i][k];// work=work+all
                    }
                    i = 0;//每次都从头开始找
                }
            } else {
                i++; //不满足false找下一个进程
            }
        }
        // 判断所有进程是Finish是否为true，满足说明安全
        for (int m = 0; m < a; m++) {
            if (Finish[m] == false) {
                System.out.println("该状态下系统不安全！");
                return false;
            }
        }


        //打印检测过程 表头
        System.out.println();
        System.out.println("安全性算法分析过程");
          Init init = new Init(a,b);
            init.printKong();
            System.out.print(" Work" );
            init.printKong();
            System.out.print(" Need");
            init.printKong();
            System.out.print(" All");
            init.printKong();
            System.out.print(" Work+All");
            System.out.println();
            System.out.print("  ");
            for (int m = 0; m < 4; m++) {
                System.out.print("  ");
                for (int n = 0; n < b; n++) {
                    System.out.print(resourceName[n] + " ");
                }
            }
        System.out.println();
        //打印进程情况
        for (int m = 0; m < a; m++) {
            int x = abc[m];
            System.out.print(processName[x] + "  ");
            for (int n = 0; n < b; n++) {
                System.out.print(New[x][n] + " ");
            }
            System.out.print("  ");
            for (int n = 0; n < b; n++) {
                System.out.print(Need[x][n] + " ");
            }
            System.out.print("  ");
            for (int n = 0; n < b; n++) {
                System.out.print(Allocation[x][n] + " ");
            }
            System.out.print("  ");
            for (int n = 0; n < b; n++) {
                System.out.print(Allocation[x][n] + New[x][n] + " ");
            }
            System.out.println();
        }
        System.out.println("该状态下系统安全！");
        System.out.print("因为能找到安全序列:");
        for(int m = 0; m < abc.length; m++){
            System.out.print(processName[abc[m]]+" ");
        }
        System.out.println();
                return true;
    }


}
