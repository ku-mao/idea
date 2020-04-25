package edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interview {
    public static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        TreeNode(char x) {
            val = x;
        }
    }

    /**
     * 根据带有空结点的先序遍历构建一棵树,输出他的中序遍历结果
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //先根据先序遍历构建树
           // TreeNode root = build(sc.nextLine());
            index = 0;
            TreeNode root = createTree(sc.nextLine());
            //再进行中序遍历
            inOrder(root);
            System.out.println();
        }
    }

    private static int index;
//    private static TreeNode build(String line) {
//        index = 0;
//        return createTree(line);
//    }

    private static TreeNode createTree(String line) {
        char c = line.charAt(index);
        if(c == '#') {
            return null;
        }
        //如果结点非空,就访问这个结点,也就是创建这个结点
        TreeNode node  = new TreeNode(c);
        index++;
        node.left = createTree(line);
        index++;
        node.right = createTree(line);
        return node;
    }

    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }


}


