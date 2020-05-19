package edu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet <>();
        set.add("java");
        set.add("java");
        set.add("java");
        set.add("C++");
        set.add("C");
        set.add("python");
        System.out.println(set.contains("java"));

        set.remove("python");
        System.out.println(set.contains("python"));
        System.out.println(set);

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
