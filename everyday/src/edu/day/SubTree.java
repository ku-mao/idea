package edu.day;

public class SubTree {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode cur = new TreeNode(2);
        root1.left = cur;
        cur = new TreeNode(3);
        root1.right = cur;
        TreeNode root2 = new TreeNode(2);
        System.out.println(HasSubtree(root1, root2));
    }
    private static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean flag = false;
        if (root1.val == root2.val) {
            flag = isSame(root1, root2);
        }
        if (!flag) {
            flag = HasSubtree(root1.left, root2);
        }
        if (!flag) {
            flag = HasSubtree(root1.right, root2);
        }
        return flag;
    }
    private static boolean isSame(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        return (isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right));
    }
}
