package edu;

public class Account {
    // 设定账户初始状态为GreenState
    private AccountState state = new GreenState();
    private String owner;
    private double balance;

    public Account(String owner, double init) {
        this.owner = owner;
        this.balance = init;
        System.out.println("小花开户,初始余额为:" + init + "元");
        System.out.println("-----------------------------------");
    }

    // 设置账户状态
    public void setState(AccountState state) {
        this.state = state;
    }

    // 获取账户金额
    public double getBalance() {
        return balance;
    }

    // 当前账户存钱
    public void deposit(double money) {
        System.out.println("小花存款:" + money + "元");
        this.balance += money;
        System.out.println("现在余额为:" + this.balance + "元");
        state.stateCheck(this);
        System.out.println("现在账户状态为:" + state);
        System.out.println("-----------------------------------");
    }

    // 当前账户取钱
    public void withdraw(double money) {
        System.out.println("小花取款:" + money + "元");
        if (this.balance < -1000) {
            System.out.println("账户被冻结,取款失败");
        } else {
            this.balance -= money;
        }
        System.out.println("现在余额为:" + this.balance + "元");
        state.stateCheck(this);
        System.out.println("现在账户状态为:" + state);
        System.out.println("-----------------------------------");
    }
}
