package edu;

public class LinkedList {
   private class Node{
        private int data;
        private Node next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head = null;
    private int size = 0;

    //添加元素
    public void add(int d) {
        Node n = new Node();
        n.setData(d);
        if(head == null){
            head = n;
        } else{
            Node temp = head;
            for(int i = 0 ; i < size - 1 ; i++){//找到链表的尾
               temp = temp.next;
            }
            temp.setNext(n);
        }
        size++;
    }

    //查找元素
    public  Integer get(int i ){
        if(i==0) return head.getData();
        if(i < 0 || i >= size) return  null;
        else{
            Node temp = head;
            for(int t = 0 ; t < i ; t++){
                temp = temp.next;//不判断的话，继续找可能会越界
                if(temp==null) return null;
            }
            return temp.getData();
        }
    }

    //删除元素
    public void remove(int i) {
        if(i == 0) head = head.next;
        if(i < 0 || i >= size ) return;
        else {
            Node temp = head;
            Node last = null;
            for(int t = 0 ; t < i ; t++){
                last = temp;
                temp = temp.next;//不判断的话，继续找可能会越界
                if(temp==null) return ;
            }
            last.next = temp.next;
        }
         size--;

    }
}
