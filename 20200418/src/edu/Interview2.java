package edu;

import java.util.ArrayList;
import java.util.List;

public class Interview2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     *给你一个二叉树，请你返回其按 层序遍历 得到的节点值。
     *  （即逐层地，从左到右访问所有节点）
     */
    private List<List<Integer>> result = new ArrayList<>(); //保存二维数组的结果值
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return null;
        }
        helpLevelOrder(root,0);
        return result;

    }

    //level 从0开始,方便获取当前行,和result的下标对应
    private void helpLevelOrder(TreeNode root, int level) {
        if(level == result.size()) {
            result.add(new ArrayList <>());
        }
        //拿到当前行
        List<Integer> curRow = result.get(level);
        curRow.add(root.val);
        //处理下一行
        if(root.left != null) {
            helpLevelOrder(root.left,level + 1);
        }
        if(root.right != null) {
            helpLevelOrder(root.right,level + 1);
        }
    }


    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
     * （一个节点也可以是它自己的祖先）
     * @param root
     * @param p
     * @param q
     * @return
     */
    private TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        findNode(root, p, q);
        return lca;
    }

    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return false;
        }
        //以后序遍历的方式进行查找
        int left = findNode(root.left, p, q) ? 1 : 0;
        int right = findNode(root.right, p, q) ? 1 : 0;
        //访问根节点
        int mid = (root == p || root == q) ? 1 : 0;
        //3个位置出现2个
        if(left + right + mid == 2) {
            lca = root;
        }
        //找到p或者q就返回true
        return (left + right + mid) > 0;
    }

}
