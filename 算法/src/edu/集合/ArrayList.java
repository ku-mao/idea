package edu.集合;

public class ArrayList implements List {
    int length = 10;
    Object[] data = new Object[length];
    int size = 0;

    //添加元素
    public void add(Object o){
        if(size < length){
            this.data[size] = o;
        }else {
            length *= 2;
            Object[] a = new Object[length];
            for(int i = 0 ; i < size ; i++ ){
                a[i] = data[i];
            }
            data = a;
            data[size] = o;
        }
        size++;
    }

    //查找元素
    public  Object get(int i ){
        if( 0 > i || i >= size){
            return null;
        }
        return data[i];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        //局部类
       Iterator iterator =  new Iterator() {
           private int i = 0;
            @Override
           public boolean hasNext() {
               if(i < size) return true;
               return false;
           }

           @Override
           public Object next() {
               Object o = data[i];
               i++;
               return o;
           }
       };
        return iterator;
    }



    //删除元素
    public void remove(int i){
        if( 0 > i || i >= size){
            return ;
        }
        for( int t = i ; t < length - 1 ; t++){
            data[i] = data[i + 1];
        }
        size--;
    }
}
