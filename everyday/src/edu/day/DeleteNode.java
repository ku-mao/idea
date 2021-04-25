package edu.day;

public class DeleteNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        ListNode node = new ListNode(1);
        cur.next = node;
        cur = node;
        node = new ListNode(2);
        cur.next = node;
        cur = node;
        node = new ListNode(3);
        cur.next = node;
        cur = node;
        node = new ListNode(3);
        cur.next = node;
        cur = node;
        ListNode root = deleteDuplicates(head);
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }
    }
    private static ListNode deleteDuplicates (ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
