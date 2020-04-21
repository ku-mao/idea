package edu;

import java.util.ArrayList;
import java.util.List;

public class Practice {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    private List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            //空树返回一个空的List 而不是null
            return result;
        }
        result.add(root.val);

        // addAll()是添加一个list就是
        // 把集合中所有的元素都add到集合中
        //递归访问左子树
        result.addAll(preOrderTraversal(root.left));
        //递归访问右子树
        result.addAll(preOrderTraversal(root.right));

        return result;
    }

    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList <>();
        if(root == null) {
            //空树返回一个空的List 而不是null
            return result;
        }

        //递归访问左子树
        result.addAll(inOrderTraversal(root.left));
        //访问根节点
        result.add(root.val);
        //递归访问右子树
        result.addAll(inOrderTraversal(root.right));

        return result;
    }


    private static List<Integer> postOrderTraversal (TreeNode root) {
        List<Integer> result = new ArrayList <>();
        if(root == null) {
            return result;
        }
        result.addAll(postOrderTraversal(root.left));
        result.addAll(postOrderTraversal(root.right));
        result.add(root.val);
        return result;
    }

    /**
     * 判断两个树是否相同,结构相同,并且值也相等
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            //两树都空
            return true;
        }

        if(p == null || q == null ) {
            //有一个树为空
            return false;
        }

        //判断p和q是否相等,
        return (p.val == q.val)
                && isSameTree(p.left,q.left)
                && isSameTree(p.right,q.right);
    }

    /**
     * 给定两个非空二叉树 s 和 t，
     * 检验s 中是否包含和 t 具有相同结构和节点值的子树。
     * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。
     * s 也可以看做它自身的一棵子树
     *
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) {
            return false;
        }
        return (isSameTree(s,t) || isSubtree(s.left,t) || isSubtree(s.right, t));

    }

    /**
     * 求树的深度(最大)
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            //root为叶子结点
            return 1;
        }
        //总的深度 = 1 + max(左子树的深度 , 右子树的深度)
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth,rightDepth);

    }


    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return (leftDepth - rightDepth <= 1 && leftDepth - rightDepth >= -1)
                && isBalanced(root.left) && isBalanced(root.right);
    }
}
