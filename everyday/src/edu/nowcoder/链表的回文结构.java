package edu.nowcoder;

import java.util.LinkedList;
import java.util.Scanner;

public class 链表的回文结构 {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static boolean chkPalindrome(ListNode A) {
        if (A == null) {
            return false;
        }
        ListNode fast = A;
        ListNode slow = A;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转以slow为头结点的链表
        fast = slow.next;
        ListNode curNext = fast.next;
        while (curNext != null) {
            fast.next = slow;
            slow = fast;
            fast = curNext;
            curNext = curNext.next;
        }
        fast.next = slow;
        while (A != fast && A.next != fast) {
            if (A.val == fast.val) {
                A = A.next;
                fast = fast.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList<ListNode> list = new LinkedList <>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个链表, 判断是否属于回文串: ");
        int n = scanner.nextInt();
        while (n > 0) {
           list.addLast(new ListNode(scanner.nextInt()));
           n--;
        }
        System.out.println(chkPalindrome(list.get(0)));
    }
}
