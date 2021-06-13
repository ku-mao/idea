package edu.day;

import java.util.*;

/**
 * 之字形打印二叉树的结点
 */
public class ZPrint {
    private int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private static List<TreeNode> nodeList = null;
    /**
     * 内部类：节点
     */
    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int newData) {
            left = null;
            right = null;
            val = newData;
        }
    }
    public  void createBinTree() {
        nodeList = new LinkedList<>();
        // 将一个数组的值依次转换为Node节点
        for (int i = 0; i < array.length; i++) {
            nodeList.add(new TreeNode(array[i]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
            // 右孩子
            nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex * 2 + 2);
        }
    }
    public static void main(String[] args) {
        ZPrint print = new ZPrint();
        print.createBinTree();
        ArrayList<ArrayList<Integer>> lists = print.zigzagLevelOrder(nodeList.get(0));
        System.out.println(lists.toString());

    }
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        int flag = 1;
        //1表示当前层的孩子结点从左向右入栈
        //0表示当前层的孩子结点从右向左入栈
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        stack.push(root);
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.empty()) {
            int size = stack.size();
            while (size > 0) {
                TreeNode cur = stack.pop();
                list.add(cur.val);
                TreeNode tmp1 = flag == 1 ? cur.left : cur.right;
                TreeNode tmp2 = flag == 1 ? cur.right : cur.left;
                if (tmp1 != null) {
                    queue.offer(tmp1);
                }
                if (tmp2 != null) {
                    queue.offer(tmp2);
                }
                size--;
            }
            lists.add(new ArrayList(list));
            list.clear();
            while (!queue.isEmpty()) {
                stack.push(queue.poll());
            }
            flag = (flag == 1) ? 0 : 1;
        }
        return lists;
    }
}
