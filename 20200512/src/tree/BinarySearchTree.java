package tree;

public class BinarySearchTree {
    public static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    //根节点
    private Node root = null;

    public Node find(int key) {
        Node cur = root;
        while (cur != null) {
            if (key < cur.key) {
                //去左子树中找
                cur = cur.left;
            } else if (key > cur.key) {
                //去右子树中找
                cur = cur.right;
            } else {
                return cur;
            }
        }
        //循环完后都没找到,说明该节点不存在
        return null;
    }

    public boolean insert(int key) {
        if(root == null) {
            root = new Node(key);
        }
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if(key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else if( key > cur.key) {
                parent = cur;
                cur = cur.right;
            } else {
                return false;
            }
        }
        //当循环结束说明当前要插入的元素是parent的子树
        if (key < parent.key) {
            parent.left = new Node(key);
        } else {
            parent.right = new Node(key);
        }
        return true;
    }

    public boolean remove(int key) {
        Node cur = root;
        Node parent = null;
        if(root == null) {
            return false;
        }
        while (cur != null) {
            if (key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else if (key < cur.key) {
                parent = cur;
                cur = cur.right;
            } else {
                removeNode(parent, cur);
                return true;
            }
        }
        return false;
    }

    private void removeNode(Node parent, Node cur) {
        if (cur.left == null) { //1.要删除的元素没有左子树
            if (cur == root) { //1.1要删除的元素是根节点
                root = cur.right;
            } else if (cur == parent.left) { //1.2要删除的元素是父节点的左子树
                parent.left = cur.right;
            } else if (cur == parent.right) { //1.3要删除的元素是父节点的右子树
                parent.right = cur.right;
            }
        } else if (cur.right == null) { //2.要删除的元素没有右子树
            if (cur == root) { //2.1要删除的元素是根节点
                root = cur.left;
            } else if (cur == parent.left) { //2.2 要删除的结点是父节点的左子树
                parent.left = cur.left;
            } else if (cur == parent.right) { //2.3要删除的结点是父结点的右子树
                parent.right = cur.left;
            }
        } else { //3.当前要删除的结点左右子树都不为空
            //1)找替罪羊结点(右子树中最小的元素)
            Node goatParent = cur;//替罪羊节点的父节点
            Node scapeGoat = cur.right;//替罪羊结点
            while (scapeGoat.left != null) {
                goatParent = scapeGoat;
                scapeGoat = scapeGoat.left;
            }
            //循环结束,找到替罪羊结点
            //2)把替罪羊结点的值赋给待删除结点
            cur.key = scapeGoat.key;
            //3)删除替罪羊结点
            if (scapeGoat == goatParent.left) {
                goatParent.left = scapeGoat.right;
            } else {
                goatParent.right = scapeGoat.right;
            }
        }
    }


    public void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.key + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.key + " ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(9);
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(3);
        tree.insert(6);
        tree.insert(8);

        tree.remove(5);
        //查看树的结构
        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        Node cur = tree.find(2);
        System.out.println(cur.key);
    }
}
