public class Animal {
    public Animal(String name) {
        this.name = name;
    }
    public Animal () {

    }
    public String name;

    public void eat() {
        System.out.println(this.name + "正在吃");
    }
}
