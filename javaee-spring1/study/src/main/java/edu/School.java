package edu;

import java.util.List;

public class School {
    private List<Student> students;

    public List <Student> getStudents() {
        return students;
    }

    public void setStudents(List <Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "School{" +
                "students=" + students +
                '}';
    }
}
