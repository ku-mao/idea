package edu.practice;



public class A {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(s.concat("b"));
        StringBuilder d = new StringBuilder();
        d.append(9);
        System.out.println(d.append(false));
    }
}
