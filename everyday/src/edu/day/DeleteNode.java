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
//        while (head != null) {
//            System.out.print(head.val + " ");
//            head = head.next;
//        }
//        System.out.println();

//        ListNode root = deleteDuplicates(head);
//        while (root != null) {
//            System.out.print(root.val + " ");
//            root = root.next;
//        }
//        System.out.println();
        ListNode root2 = deleteDuplicates2(head);
        while (root2 != null) {
            System.out.print(root2.val + " ");
            root2 = root2.next;
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
    private static ListNode deleteDuplicates2(ListNode head) {
        ListNode pHead = new ListNode(-1);
        pHead.next = head;
        ListNode cur = pHead;
        while (head != null && head.next != null ) {
            if ( head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                cur.next = head.next;
                head = head.next;
            } else {
                cur = head;
                head = head.next;
            }
        }
        return pHead.next;
    }
}
