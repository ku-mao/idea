package edu;

public class TestDemo1 {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,1);
        myArrayList.add(1,2);
        myArrayList.add(2,3);
        myArrayList.add(3,4);
        myArrayList.add(4,5);
        myArrayList.display();//1 2 3 4 5

        myArrayList.add(3,10);
        myArrayList.display();//1 2 3 10 4 5
        /*System.out.println(myArrayList.contains(10));
        System.out.println("********删除********");
        myArrayList.remove(4);
        myArrayList.display();*/
    }
}
