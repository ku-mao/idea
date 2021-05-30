package edu.day;

import java.util.HashSet;
import java.util.Set;

class LNode{
    int val;
    LNode next;
    public  LNode(int val) {
        this.val = val;
    }
}
public class Dele {
    public static LNode head = null;
    public static void main(String[] args) {
       Dele dele = new Dele();
       dele.add(2);
       dele.add(2);
       dele.add(3);
       dele.add(4);
       dele.add(5);
       dele.add(2);
       dele.print(head);
        System.out.println();
       dele.delete(head);
       dele.print(head);
    }
    public LNode delete(LNode head) {
        Set<Integer> set = new HashSet <>();
        LNode cur = head.next;
        LNode pre = head;
        set.add(pre.val);
        while (cur != null) {
            if (!set.contains(cur.val)) {
                pre = cur;
                cur = cur.next;
            } else {
                pre.next = cur.next;
                cur = pre.next;
            }
        }
        return head;
    }

    public void add(int val) {
        LNode node = new LNode(val);
        if (head == null) {
            head = node;
        } else {
            LNode tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }
    public void print(LNode head) {
        LNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}
