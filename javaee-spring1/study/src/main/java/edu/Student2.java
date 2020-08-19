package edu;

/**
 * 相当于单链表结构
 */
public class Student2 {
    private String name;
    private int age;
    private Student2 next;

    public Student2 getNext() {
        return next;
    }

    public void setNext(Student2 next) {
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", next=" + next +
                '}';
    }
}
