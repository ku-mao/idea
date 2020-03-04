package collections;

import edu.集合.Test.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TestCollections {
    @Test
    public void test1(){
        List<Student> list = new ArrayList <>();
        //当对象里面没继承比较的方法时，自己写
        Collections.sort(list,
                ((o1, o2) -> {
                    if(o1 instanceof Student && o2 instanceof Student){
                        Student s1 = (Student) o1;
                        Student s2 = (Student) o2;
                        if(s1.getId() > s2.getId()) return 1;
                        if(s1.getId() < s2.getId()) return -1;
                        return 0;
                    }
                    throw new RuntimeException("类型不对，无法比较");
                }));

    }

    @Test
    public void test2(){
        List<Integer> list = new ArrayList <>();
        list.add(24);
        list.add(34);
        list.add(89);
        list.add(3);
        list.add(87);
        System.out.println(list);

        Collections.reverse(list);//反转
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);//排序 默认升序


        Collections.swap(list,0,4);//交换
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);//随机打乱顺序


    }
}
