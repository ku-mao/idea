package edu.day;

public class Num {
    public static void main (String[] args) {
        int i = 0;
        boolean flag = false;
        while (true) {
            flag = judge(i + 100) && judge(i + 100 + 168);
            if (flag) {
                System.out.println(i);
                break;
            } else {
                i++;
            }
        }
    }
    private static boolean judge(int num) {
        int m = (int) Math.sqrt(num);
        if (m * m == num) {
            return true;
        }
        return false;
    }
}
