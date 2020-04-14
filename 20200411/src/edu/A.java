package edu;


public class A<T> {
        T value;

        A(T value) {
            this.value = value;
        }

        T get() {
            return value;
        }
    public static void main(String[] args) {
        A<String> a = new A <>("Hello");
        String str = a.get();
        System.out.println(str);

    }
}



