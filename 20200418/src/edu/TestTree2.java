package edu;


import java.util.Stack;

public class TestTree2 {
    public static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;
        TreeNode(char x) { val = x; }
    }
    static TreeNode build() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return A;
    }

    /**
     * 循环实现先序遍历
     * @param root
     */
    private static void preOrder(TreeNode root){
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack <>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            if(top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
    }

    private static void inOrder(TreeNode root) {
        if( root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack <>();
        TreeNode cur = root;
        while (true) {
            //1.cur 一直往左找,循环入栈,直到cur为空
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //2.取栈顶元素开始访问呢,如果栈为空 说明访问结束
            if(stack.empty()) {
                break;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val +" ");

            //3.cur 从top的右子树出发,重复1和2
            cur = top.right;
        }
    }

    private static void  postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack <>();
        TreeNode cur = root;
        //prev 用来记录上一个被访问过的结点,初始情况下没有任何值
        TreeNode prev = null;
        while (true){
            //1.cur 循环往左找,遇到的非空结点都入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            //2.取栈顶元素,看看能不能访问这个元素
            //a)右子树为空
            //b)右子树被访问过
            if(stack.empty()) {
                break;
            }
            TreeNode top = stack.peek();//只是取元素判断一下,并没有出栈
            if(top.right == null || top.right == prev) {
                //可以访问top了
                System.out.print(top.val +" ");
                stack.pop();
                prev = top;
            } else {
                //3.让cur 从top.right出发,继续循环1和2
                cur = top.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = build();
        //preOrder(root);
        //inOrder(root);
       postOrder(root);
    }
 }
