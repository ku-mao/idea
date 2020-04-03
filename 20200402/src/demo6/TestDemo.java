package demo6;

import java.util.Arrays;

/**
 * 自定义类型排序->implements Comparable
 */

class Student implements Comparable<Student> {

    public String name;
    public int age;
    public int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        /*if (this.age < o.age) return -1;
        if (this.age == o.age) return 0;
        return 1;*/
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("zhangsan",18,78);
        students[1] = new Student("lisi",16,89);
        students[2] = new Student("wangmazi",20,98);
        Arrays.sort(students);
        //把数组中的元素转化为字符串输出的时候，会调用Student的toString()
        System.out.println(Arrays.toString(students));
    }
}
