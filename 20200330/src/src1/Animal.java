package src1;

public class Animal {
    public Animal(String name) {
        this.name = name;
    }

    public String name;
    protected String sex;

    int count;

    public void eat() {
        System.out.println(this.name + "正在吃");
    }
}
