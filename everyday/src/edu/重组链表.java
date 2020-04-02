package edu;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class 重组链表 {
    public static void main(String[] args) {
        //尾插法构建链表进行测试
        ListNode header = new ListNode(Integer.MAX_VALUE);
        ListNode tail = header;
        ListNode newNode = null;
        int arr [] = new int[]{1,2,3,4,5};
        for (int i = 0; i < arr.length; i++) {
            newNode = new ListNode(arr[i]);
            tail.next = newNode;
            tail = tail.next;
        }
        header = header.next;

        reorderList(header);

        while(header != null){
            System.out.print(header.val + "\t");
            header = header.next;
        }

    }
    public static void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        //slow、fast起始指向头节点(不是哑结点)，执行以下循环后，将链表一分为二，
        //第一段： [head,pre]，第二段[slow,fast]，
        //如果原链表节点为奇数个，fast不为null,
        //如果原链表节点为偶数个，fast为null,
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        //将第二段链表翻转,翻转之后头节点为 preNode
        ListNode preNode = null;
        ListNode curNode = slow;
        ListNode nextNode = null;
        while(curNode != null){
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        //将两段链表合并为一段
        ListNode header = new ListNode(Integer.MAX_VALUE);
        ListNode list = header;
        while(head != null && preNode != null){
            list.next = head;
            head = head.next;

            list.next.next = preNode;
            preNode = preNode.next;

            list = list.next.next;
        }
        if(preNode != null){
            list.next = preNode;
        }
        head = header.next;
    }
}

