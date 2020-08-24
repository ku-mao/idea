package edu.nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 之字形打印二叉树 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        if(pRoot == null){
            return result;
        }
        Stack<TreeNode> st = new Stack<>();
        Queue<TreeNode> q = new LinkedList<>(); //临时区域
        st.push(pRoot);
        int dir = 1; //1：代表left->right式入栈. 2: 代表right->left式入栈
        ArrayList<Integer> list = new ArrayList<>();//保存一层结果的临时变量
        while(!st.empty()){
            int size = st.size(); //清空本层所有节点，将下层节点按照要求入栈，栈具有天然的逆序的能力
            for(int i = 0; i < size; i++){
                TreeNode curr = st.pop();
                list.add(curr.val);
                TreeNode first = (dir == 1) ? curr.left : curr.right;
                TreeNode second = (dir == 1) ? curr.right : curr.left;
                if(first != null) q.offer(first);
                if(second != null) q.offer(second);
            } //本层遍历完毕，入结果集
            result.add(new ArrayList(list)); //一定要注意浅拷贝问题
            list.clear();
            //将所有节点入栈，进行逆序
            while(!q.isEmpty()){
                st.push(q.poll());
            }
            dir = (dir == 1) ? 2 : 1;
        }
        return result;
    }
}

