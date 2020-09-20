package edu.nowcoder;


import java.util.Scanner;

public class 涂色 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String t = scanner.nextLine();
            boolean[] use = new boolean[s.length()];
            int count = 0;
            for (int i = 0; i < t.length(); i++) {
                for (int j = 0; j < s.length(); j++) {
                    if (t.charAt(i) == s.charAt(j) && !use[j]) {
                        count++;
                        use[j] = true;
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
