package edu.nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 查找关联用户 {
    public static int cluster(List<String[]> loginInfo, String userId) {
        int count = 0;
        int i = 0;
        for (; i < loginInfo.size(); i++) {
            if (loginInfo.get(i)[0].equals(userId)) {
                break;
            }
        }
        ArrayList<String> users = new ArrayList <>();
        for (String[] s : loginInfo) {
            if (loginInfo.get(i)[1].equals(s[1])) {
                users.add(s[1]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String[]> loginInfo = new ArrayList <>();
        while (scanner.hasNext()) {
            String[] str = scanner.nextLine().split(",");
            loginInfo.add(str);
        }
        String[] s = loginInfo.remove(loginInfo.size() - 1);
        String userId = s[0];
        cluster(loginInfo, userId);
    }
}
