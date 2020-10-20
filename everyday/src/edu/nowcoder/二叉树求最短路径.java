package edu.nowcoder;

import java.util.ArrayList;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class 二叉树求最短路径 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //[[1,2],[1,3],[2,4],[2,5],[4,8],[4,9],[3,6],[3,7]],2,8
        while (scanner.hasNext()) {
            String str = scanner.nextLine().substring(1);
            String[] s = str.split(",");
            ArrayList<Integer> arrayList = new ArrayList <>();
            int num = 0;
            for (int i = 0; i < s.length - 3; i++) {
                 num = Integer.parseInt(s[i].substring(1));
                arrayList.add(num);
                num = Integer.parseInt(s[i].substring(0, s[i].length() - 1));
                arrayList.add(num);
            }
            num = Integer.parseInt(s[s.length - 3].substring(0, s[s.length - 3].length() - 2));
            arrayList.add(num);
            int start = Integer.parseInt(s[s.length - 2]);
            int end = Integer.parseInt(s[s.length - 3]);
            int len = arrayList.size() / 2;
            int[][] tree = new int[len][2];
            int j = 0;
            for (int i = 0; i < len && j < arrayList.size(); i++) {
                tree[i][0] = arrayList.get(j++);
                tree[i][1] = arrayList.get(j++);
            }
            getLength(tree, start, end);
        }
    }
    public static int getLength(int[][] tree, int start, int end) {
        TreeNode root = build(tree);

    }

    private static TreeNode build(int[][] tree) {
        TreeNode root = new TreeNode(tree[0][0]);
        TreeNode cur = root;
        for (int i = 0; i < tree.length - 1;) {
            if (tree[i][0] == tree[i + 1][0]) {
                cur.left.val = tree[i][1];
                cur.right.val = tree[i+1][1];
                i += 2;
            } else {
                cur.left.val = tree[i][1];
                i++;
            }
            if (cur.left.val == tree[i][0]) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return root;
    }
}
