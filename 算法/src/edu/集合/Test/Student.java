package edu.集合.Test;

import java.util.Objects;

public class Student implements Comparable{
    private  int id;
    private  String name;
    private char sex;

    public Student(int id, String name, char sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                sex == student.sex &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex);
    }

    /**
     * 传进来的对象比自己小时，返回1
     * 传进来的对象比自己小时，返回-1
     * 否则返回0
      */

    @Override
    public int compareTo(Object o) {
        if(o instanceof Student){
           Student s = (Student) o;
            if(this.id > s.id) return 1;
            else if(this.id < s.id) return  -1;
            return 0;
        }
           throw  new RuntimeException("类型不匹配");

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }

//    @Override
//    public int hashCode() {
//        return new Integer(id).hashCode() + name.hashCode() + new Character(sex).hashCode() ;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if(obj instanceof Student){
//            Student s = (Student) obj;
//            if(s.id == this.id && s.name.equals(this.name) && s.sex == this.sex)
//                return true;
//        }
//        return false;
//    }
}
