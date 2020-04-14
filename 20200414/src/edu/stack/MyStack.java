package edu.stack;

public class MyStack {
    //基于顺序表实现栈
    private int[] array = new int[100];
    //array中的[0,size) 区间的元素是栈中的有效元素
    //0号元素是栈底,size-1位置的元素相当于栈顶
    private int size = 0;

    public void push(int value) {
        array[size] = value;
        size++;
    }

    public Integer pop() {
        if(size <= 0) {
           return null;
        }
        int ret = array[size - 1];
        size--;
        return ret;
    }

    public Integer peek() {
        if(size <= 0) {
            return null;
        }
        int ret = array[size - 1];
        return ret;
    }


    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

//        Integer cur = null;
//        while ((cur = myStack.pop()) != null) {
//            System.out.println(cur);
//        }
        while (true) {
            Integer cur = myStack.pop();
            if(cur == null) {
                break;
            }
            System.out.println(cur);
        }
    }
}
