package edu.day;

import java.util.Scanner;

class Node {
    int val;
    public Node() {

    }

    public Node(int val) {
       this.val = val;
    }
    Node next = null;
}
public class JoneCycle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        calc(n);
    }

    private static void calc(int n) {
        //构造一个循环链表
        Node head = new Node();
        Node cur = head;
        for (int i = 1; i <= n; i++) {
            Node tmp = new Node(i);
            cur.next = tmp;
            cur = tmp;
        }
        //形成一个环
        cur.next = head.next;

        //开始数数
        Node p = head.next;
        int k = 3;
        while (p.next != p) {
            for (int i = 1; i < k - 1;i++) {
                p = p.next;
            }
            System.out.print(p.next.val + "out ->");
            p.next = p.next.next;
            p = p.next;
        }
        System.out.println(p.val + "alive");
    }
}
