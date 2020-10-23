package edu.nowcoder;

/**
 * 将一棵无穷大满二叉树的结点按根结点一层一层地从左往右编号，根结点编号为1。
 * 现给定a，b为两个结点。设计一个算法，返回a、b最近的公共祖先的编号。
 * 注意其祖先也可能是结点本身。
 *
 * 测试样例：
 * 2，3
 * 返回：1
 */
public class 最近公共祖先 {
    public static int getLCA(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a / 2;
            } else {
                b = b / 2;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 6;
        int b = 1;
        System.out.println(getLCA(a, b));
    }
}
