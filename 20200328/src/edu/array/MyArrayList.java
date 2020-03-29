package edu.array;

import java.util.Arrays;

public class MyArrayList {
    private int[] elem;
    private int usedSize;
    //设置默认容量
    private static final int DEFAULT_SIZE = 5;

    public MyArrayList(){
        this.elem = new int[DEFAULT_SIZE];
        this.usedSize = 0;
    }

    // 打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize ; i++) {
            System.out.print(this.elem[i] + " ") ;
        }
        System.out.println();
    }


    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if(isFull()) {
//            System.out.println("顺序表是满的!");
//            return;
            //throw new RuntimeException("顺序表是满的!");

            //扩容
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
         checkPos(pos);
        //开始挪数据
        for (int i = this.usedSize - 1; i >= pos ; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }

    private boolean isFull() {
        if(this.usedSize == this.elem.length) {
            return true;
        }
        return false;
    }
    private boolean isEmpty() {
        if(this.usedSize == 0) {
            return true;
        }
        return false;
    }
    private boolean checkPos(int pos) {
        if(pos < 0 || pos > this.usedSize) {
//            System.out.println("pos位置不合法");
//            return;
            throw  new ArrayIndexOutOfBoundsException("pos位置不合法");
        }
        return true;
    }


    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        if(isEmpty()) {
            throw new RuntimeException("顺序表为空");
        }
        for (int i = 0; i < this.usedSize; i++) {
            if(toFind == this.elem[i]) {
                return true;
            }
        }
        return false;
    }


    // 查找某个元素对应的位置
    public int search(int toFind) {
        if(isEmpty()) return -1;
        for(int i = 0 ; i < this.usedSize ; i++) {
            if(toFind == this.elem[i]) {
                return i;
            }
        }
        return -1;
    }


    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(isEmpty()) {
            throw  new RuntimeException("顺序表为空");
        }
        checkPos(pos);
        return this.elem[pos];
    }


    //删除第一次出现的关键字key
    public void remove(int key) {
        //调用search方法 看返回值 -1 没有这个key，就不用删除
       int index = search(key);
        if(index == -1) {
            return;
        }
        for(int i = index ; i < this.usedSize - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        this.usedSize--;

    }



    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }


    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
    }


}
