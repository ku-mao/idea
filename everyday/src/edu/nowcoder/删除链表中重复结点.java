package edu.nowcoder;


public class 删除链表中重复结点 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = pHead;
        ListNode prev = newHead;
        ListNode last = pHead;
        while (last != null) {
            //找重复结点的起点
            while (last.next != null && last.val != last.next.val) {
                last = last.next;
                prev = prev.next;
            }
            //找重复结点的最后一个, 最终last是最后一个重复结点
            while (last.next != null && last.val == last.next.val) {
                last = last.next;
            }
            //走到这可能没找到重复结点 prev.next = last
            if (prev.next != last) {
                //找到需要去重
                prev.next = last.next;
            }
            //寻找下一段重复的结点
            last = last.next;
        }
        return newHead.next;
    }
}
