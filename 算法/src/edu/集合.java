package edu;

class ArrayList{
    int length = 10;
    int[] data = new int[length];
    int size = 0;

    //添加元素
    public void add(int d){
        if(size < length){
            this.data[size] = d;
        }else {
            length *= 2;
            int[] a = new int[length];
            for(int i = 0 ; i < size ; i++ ){
                a[i] = data[i];
            }
            data = a;
            data[size] = d;
        }
        size++;
    }

    //查找元素
    public  Integer get(int i ){
        if( 0 > i || i >= size){
            return null;
        }
        return data[i];
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
public class 集合 {
    public static void main(String[] args) {
       ArrayList a = new ArrayList();
        a.add(2);//可以无限加
        a.add(222);
        a.add(52);
        a.add(552);
        a.add(21);
        a.add(12);
        a.add(0);
        a.add(76);
        a.add(2);
        a.add(2);
        a.add(2);
        a.add(2);
        a.add(4);
        System.out.println(a.get(4));
        a.remove(4);
        System.out.println(a.get(4));

        LinkedList b = new LinkedList();
        b.add(20);
        b.add(45);
        b.add(98);

        b.remove(2);

        System.out.println( b.get(2));
    }

}

