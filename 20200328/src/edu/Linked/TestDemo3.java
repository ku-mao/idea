package edu.Linked;

public class TestDemo3 {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addLast(10);
        doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(29);
        doubleLinkedList.addLast(17);
        doubleLinkedList.addLast(18);
        doubleLinkedList.addFirst(0);
        doubleLinkedList.display();
        System.out.println("******插入");
        doubleLinkedList.addIndex(0,888);
        doubleLinkedList.display();
        doubleLinkedList.addIndex(7,666);
        doubleLinkedList.display();
        doubleLinkedList.addIndex(3,666);
        doubleLinkedList.display();

        System.out.println(doubleLinkedList.contains(666));
        System.out.println("******移除");
        doubleLinkedList.removeAllKey(666);
        doubleLinkedList.display();

    }
}
