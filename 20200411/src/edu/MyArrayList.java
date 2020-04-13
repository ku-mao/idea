package edu;

class Student {
    public String name;
    public int age;
}

public class MyArrayList<E> {
//  private E[] array = new E[100];这种方式不可
    private E[] array = (E[])new Object[100];
    private int size;

    void add(E o) {
        array[size] = o;
        size++;
    }

    E get(int index){
        return array[index];
    }

    public static void main(String[] args) {
//        MyArrayList myArrayList = new MyArrayList();
//        myArrayList.add("10124");
//        myArrayList.add("drr");
//        myArrayList.add("love java");
//
//        String str =(String)myArrayList.get(0);
//
//        MyArrayList myArrayList1 = new MyArrayList();
//        myArrayList1.add(new Student());
//        myArrayList1.add(new Student());

        MyArrayList<String> myArrayList = new MyArrayList <>();
        myArrayList.add("haha");
        String string = myArrayList.get(0);

        MyArrayList<Student> myArrayList1 = new MyArrayList <>();
        myArrayList1.add(new Student());
        Student stu = myArrayList1.get(0);

    }
}
