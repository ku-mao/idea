package edu;

public class LinkedList implements List{
   private class Node{
        private Object data;
        private Node next;

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
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
    public void add(Object d) {
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
    public  Object get(int i ){
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

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {

        Iterator iterator = new Iterator() {
            int i = 0;
            @Override
            public boolean hasNext() {
                if(i < size) return true;
                return false;
            }

            @Override
            public Object next() {
                Object o = null;
                if(i == 0) o = head.data;
                else {
                    Node temp = head;
                    for(int t = 0;t < i; t++){
                        temp = temp.next;
                    }
                    o = temp.data;
                }
                i++;
                return o;
            }
        };
        return iterator;
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
