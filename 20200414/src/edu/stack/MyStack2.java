package edu.stack;

public class MyStack2 {
    //使用链表实现栈
    static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    //链表头部表示栈顶,链表尾部表示栈底

    Node head = new Node(-1);
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = head.next;
        head.next = newNode;
    }

    public Integer peek(){
        if(head.next == null) {
            return null;
        }
        return head.next.val;
    }
    public Integer pop() {
        Node toDel = head.next;
        if(toDel == null) {
            return  null;
        }
        head.next = toDel.next;
        return toDel.val;
    }

}
