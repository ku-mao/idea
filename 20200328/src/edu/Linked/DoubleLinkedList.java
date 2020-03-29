package edu.Linked;

/**
 * 无头双向不循环的链表
 */

class ListNode {
    public int val;
    public ListNode prev;
    public ListNode next;
    public ListNode (int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
public class DoubleLinkedList {

    public ListNode head;//头
    public ListNode tail;//尾

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            return;
        }
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if(this.head == null) {
            this.head = node;
            this.tail = node;
        }else {
            this.tail.next = node;
            node.prev = tail;
            this.tail = node;
        }
    }

    private void check(int index) {
        if(index < 0 || index > size()) {
            throw new RuntimeException("插入位置不合法");
        }
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) {
        check(index);
        ListNode node = new ListNode(data);
        if(index == 0) {
            addFirst(data);
            return ;
        }
        if(index == size()) {
            addLast(data);
            return;
        }
        ListNode cur = this.head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        node.next = cur;
        node.prev = cur.prev;
        cur.prev.next = node;
        cur.prev = node;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode node = new ListNode(key);
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.val == node.val) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else  {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else
                    this.tail = cur.prev;
                }
                return;
            } else {
                cur = cur.next;
            }
        }

    }
    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else
                        this.tail = cur.prev;
                }
            }
                cur = cur.next;
        }
    }
    //得到单链表的长度
    public int size() {
        ListNode cur = this.head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    public void display() {
      ListNode cur = this.head;
      while (cur != null) {
          System.out.print(cur.val + " ");
          cur = cur.next;
      }
        System.out.println();
    }
    public void clear() {
        this.head = null;
        this.tail = null;
    }
}
