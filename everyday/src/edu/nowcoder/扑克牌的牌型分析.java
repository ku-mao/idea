package edu.nowcoder;

import java.util.Scanner;

public class 扑克牌的牌型分析 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            String cards = scanner.nextLine();
            String[] card = cards.split(" ");
            char[] ch1 = new char[card.length];
            char[] ch2 = new char[card.length];
            for (int i = 0; i < card.length; i++) {
                ch1[i] = card[i].charAt(0);//花色
                ch2[i] = card[i].charAt(1);//点数
            }
            for (int i = 0; i < card.length - 1; i++) {
                if (ch1[i] != ch1[i + 1]) {//花色不同
                   //
                    return;
                }
            }//一直没跳出来, 花色相同
            for (int i = 0; i < card.length; i++) {
                if (Math.abs(ch2[i] - ch2[i + 1]) != 1) {
                    System.out.println("TongHua");
                    return;
                }
            }
            if (ch2[0] == 'A' || ch1[ch1.length - 1] == 'A') {
                System.out.println("HuangJiaTongHuaShun");
                return;
            }
            System.out.println("TongHuaShun");
        }
    }
}
