package edu;

public class 集合 {
    public static void main(String[] args) {
       ArrayList a = new ArrayList();
        a.add(2);//可以无限加
        a.add(222);
        a.add(52);
        a.add(552);
        Iterator iterator = a.iterator();
       while (iterator.hasNext()){
        System.out.println(iterator.next());
       }


        LinkedList b = new LinkedList();
        b.add(20);
        b.add(45);
        b.add(98);
        Iterator it = b.iterator();
        while (it.hasNext()){
         System.out.println(it.next());
        }
    }

}

