package demo1;


class Base {
    public  int a;
    static {
        System.out.println("Base:static{}");
    }

    {
        System.out.println("Base:{}");
    }
    public Base(int a) {
        this.a = a;
        System.out.println("Base:(int)");
    }
    public void func() {
        System.out.println("Base.func()");
    }
}

class Derive extends Base{
    public int b;
    static {
        System.out.println("Derive:static{}");
    }
    {
        System.out.println("Derive:{}");
    }
    public Derive(int a, int b) {
        super(a);
        System.out.println("Derive(int,int)");
    }

    public void func() {
        //System.out.println(this.a);
        System.out.println("Derive.func()");
    }

}
public class TestDemo {

    public static void main(String[] args) {
        Base base = new Derive(10,20);
        System.out.println("*************");
        Derive derive = new Derive(10,20);
    }

    public static void main1(String[] args) {
        Base base = new Derive(10,20);
        base.func();
    }
}
