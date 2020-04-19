package edu;

public class TestTree {
     static class Node {
        public Node left;
        public Node right;
        public char val;

         public Node(char val) {
             this.val = val;
         }
     }
    static Node build() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return A;
    }

    public static void preOrder(Node root) {
         //先访问根节点,递归访问左子树,再递归访问右子树
         if(root == null) {
             return;
         }
        System.out.print(root.val + " ");
         preOrder(root.left);
         preOrder(root.right);
    }

    private static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    private static void lastOrder(Node root) {
        if(root == null) {
            return;
        }
         lastOrder(root.left);
         lastOrder(root.right);
        System.out.print(root.val + " ");
    }

//    public static int treeSize = 0;
//    public static void size(Node root) {
//       if(root == null) {
//           return;
//       }
//       treeSize++;
//       size(root.left);
//       size(root.right);
//    }

    public static int size(Node root) {
         if(root == null) {
             return 0;
         }
         //借助递归思想把问题拆分
        //整个树 = 根节点 + 左子树结点的个数 + 右子树结点的个数
        return 1 + size(root.left) + size(root.right);
    }

//     private static int leafSize = 0;
//     private static void leafSize(Node root) {
//         if(root == null) {
//             return;
//         }
//         if(root.left == null && root.right == null) {
//             leafSize++;
//             return;
//         }
//         leafSize(root.left);
//         leafSize(root.right);
//     }

    //求树中叶子结点的个数
    private static int leafSize(Node root) {
         if(root == null) {
             return 0;
         }
         if(root.left == null && root.right == null) {
             return 1;
         }
         //叶子结点的个数 = 左子树中叶子结点的个数 + 右子树中叶子结点的个数
        return leafSize(root.left) + leafSize(root.right);
    }


    /**
     * 求k层节点的个数
     */
    private static int kLevelSize(int k,Node root){
         if(root == null || k < 1) {
             return 0;
         }
         if(k == 1) {
             return 1;
         }
         //求树第k层节点的个数 = 左子树 k - 1 层结点个数 + 右子树 k - 1 层结点个数
         return kLevelSize(k - 1,root.left) + kLevelSize(k - 1,root.right);
    }

    /**
     * 在树中找值相等的结点
     * @param
     */
//    private static Node result = null;
//     private static void find(Node root, char toFind) {
//         if(root == null) {
//             return;
//         }
//         if(toFind == root.val) {
//             result = root;
//             return;
//         }
//         find(root.left,toFind);
//         find(root.right,toFind);
//     }

     private static Node find(Node root,char toFind) {
         if(root == null) {
             return null;
         }
         if(root.val == toFind) {
             return root;
         }
         Node result = find(root.left,toFind);
         if(result != null) {
             return result;
         }
         return find(root.right,toFind);
     }




    public static void main(String[] args) {
        Node root = build();
        System.out.println("前序遍历:");
        preOrder(root);
        System.out.println();
        System.out.println("中序遍历:");
        inOrder(root);
        System.out.println();
        System.out.println("后序遍历:");
        lastOrder(root);
        System.out.println();
        System.out.println("树中节点数;");
        System.out.println(size(root));
        System.out.println("树中叶子节点个数;");
        System.out.println(leafSize(root));
        System.out.println("第k层结点的个数:");
        System.out.println(kLevelSize(3, root));
        System.out.println("在树中查找结点:");
        System.out.println(find(root,'G'));

    }
}
