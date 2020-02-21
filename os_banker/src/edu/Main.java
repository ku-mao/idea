package edu;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入进程总数：");
        int a = scanner.nextInt();
        System.out.println("请输入资源总类数：");
        int b = scanner.nextInt();


        Init init = new Init(a, b);                   // 初始化状态对象
        Safe safe= new Safe();                        // 安全性算法对象
        Requset requset = new Requset();              // 银行家算法对象
        // 创建初始态T0 max all need available
        init.in();
        init.out();


        // T0状态安全性算法，初始化work finish
        safe.init(init.getWork(), init.getAvailable(), init.getFinish(),init.getNeed());
        // 安全性检查T0状态
        boolean flag = safe.safeCheck(init.getFinish(),init.getNeed(),init.getWork(),init.getProcessName(),init.getAllocation(),init.getResourceName());
            if (flag) {   //T0状态安全时再进行如下操作
                while (true) {   //可多次请求
                    requset.request(a, b);//   输入数据
                    //判断 是否 req<=need
                    boolean leg1 = requset.isLegalIn(requset.getIndex(), requset.getReq(), init.getNeed());
                    // 是否 req<=ava
                    boolean leg2 = requset.isLegalRes(requset.getReq(), init.getAvailable());
                    if (leg1 && leg2) {
                        //前两个条件满足时 试分配
                        requset.tryAll(requset.getIndex(), requset.getReq(), init.getAllocation(), init.getNeed(), init.getAvailable());
                        //对试分配的状态进行安全性检查
                        safe.init(init.getWork(), requset.getAva(),init.getFinish(),init.getNeed() );
                        boolean T1 = safe.safeCheck(init.getFinish(),requset.getN(),init.getWork(),init.getProcessName(),requset.getAll(),init.getResourceName());
                        //如果试分配安全 真分配
                        if (T1) {
                            init.setAllocation(requset.getAll());
                            init.setAvailable(requset.getAva());
                            init.setNeed(requset.getN());
                            init.out();
                        }else {
                            //回退
                            init.out();
                            System.out.println("试分配后状态不安全！！回退成功");
                        }
                    }
                    System.out.print("是否继续请求（y/n）:");
                    String c = scanner.next();
                    if (c.equalsIgnoreCase("n")) {
                        break;
                }
            }
            System.out.println("运行结束");
        }
    }
}
