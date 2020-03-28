package edu;


import edu.Linked.MyLinedList;

public class TestDemo2 {

    public static Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int lenA = 0;
        int lenB = 0;

        Node pL = headA;//长的单链表
        Node pS = headB;//短的单链表

        while(pL != null) {
            lenA ++;
            pL = pL.next;
        }
        while(pS != null) {
            lenB ++;
            pS = pS.next;
        }

        //计算完长度后指回来
        pL = headA;
        pS = headB;

        int len = lenA - lenB;
        if(len < 0) {
            pL = headB;
            pS = headA;
            len = lenB - lenA;
        }
        //可以保证pL指向了长的单链表 pS指向了短的单链表
        //len的值是一个正数
        while (len > 0) {
            pL = pL.next;
            len--;
        }

        //pL 走了差值len步
        while ( pL!= pS) {
            pS = pS.next;
            pL = pL.next;
        }
        if (pL != null  && pL == pS) {
            return pL;
        }
        return null;
    }


    public static void main(String[] args) {
        MyLinedList myLinedList = new MyLinedList();
        myLinedList.addLast(2);
        myLinedList.addLast(15);
        myLinedList.addLast(1);
        myLinedList.addLast(3);
        myLinedList.addLast(6);
        myLinedList.display();
        System.out.println("========基准=======");
        Node newHead = myLinedList.partition(4);
        myLinedList.display2(newHead);


        /*Node cur = myLinedList.findKthToTail(13);
        System.out.println(cur.data);*/
        /*System.out.println("=======反转=======");
        Node ret = myLinedList.reverseList();
        myLinedList.display2(ret);*/
    }


    public static void main2(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person();
    }



    public static void main1(String[] args) {
        MyLinedList myLinedList = new MyLinedList();
        myLinedList.addLast(2);
        myLinedList.addLast(2);
        myLinedList.addLast(2);
        myLinedList.addLast(2);
        myLinedList.addLast(2);
        myLinedList.display();//5 1 2 3 4
        System.out.println(myLinedList.contains(14));
        System.out.println(myLinedList.size());
        System.out.println("==========删除=========");
        myLinedList.removeAllKey(2);
        myLinedList.display();
    }
}
