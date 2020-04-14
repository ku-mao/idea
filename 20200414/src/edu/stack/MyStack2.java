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
    int size = 0;
    public void push(Node node) {
        if(head == null) {
            head = node;
            return;
        }
        Node tmp = head;
        head = node;
        head.next = tmp;
    }

    public Node peek(){
        if(size <= 0) {
            return null;
        }
        return null;
    }
    public Node pop() {
        if(size <= 0) {
            return null;
        }
        return null;
    }












}
