package edu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class Student {
    public String name;
    public int age;
    public String grade;
    public String school;

    public Student(String name, int age, String grade, String school) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
public class TestMap {
    public static void main(String[] args) {
        Student s1 = new Student("drr", 22, "大三", "西工院");
        Student s2 = new Student("hm", 23, "大三", "西工院");
        Student s3 = new Student("hqq", 21, "大三", "西工院");
        Student s4 = new Student("lq", 24, "大三", "西工院");

        //按照名字来取学生的整个信息
        Map<String, Student> studentMap = new TreeMap <>();
        studentMap.put(s1.name, s1);
        studentMap.put(s2.name, s2);
        studentMap.put(s3.name, s3);
        studentMap.put(s4.name, s4);

        Student s = studentMap.get("drr");
        Student stu = studentMap.getOrDefault("lm", new Student("默认名字", 0, "默认年级", "默认学校"));
        System.out.println(s);
        System.out.println(stu);

        //按照年龄来取学生的整个信息
        Map<Integer, Student> studentMap2 = new HashMap <>();
        studentMap2.put(s1.age, s1);
        studentMap2.put(s2.age, s2);
        studentMap2.put(s3.age, s3);
        studentMap2.put(s4.age, s4);
        Student student = studentMap2.get(22);
        System.out.println(student);

        for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());

        }
        Iterator<Map.Entry<String, Student>> iterator1 = studentMap.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, Student> entry = iterator1.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
