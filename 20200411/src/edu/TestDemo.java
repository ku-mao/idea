package edu;

import java.util.*;

public class TestDemo {
    /**
     * Map
     * @param args
     */
    public static void main(String[] args) {
        //实例化
        Map<String,String> map = new HashMap <>();
        System.out.println(map.isEmpty());//true
        System.out.println(map.size());//0

        //插入 put 通过key查找value 反向不行
        System.out.println("***插入****");
        map.put("及时雨","宋江");
        map.put("玉麒麟","卢俊义");
        map.put("智多星","吴用");

        //get() 根据key 找value
        System.out.println(map.get("及时雨"));//宋江
        System.out.println("zzn");//null

        //找到key ,返回对应的value,没找到返回默认值
        System.out.println(map.getOrDefault("行者","武松"));//武松
        System.out.println("*******");
        //containsKey 比较高效
        //containsValue 比较低效
        System.out.println(map.containsKey("及时雨"));//true
        System.out.println(map.containsValue("宋江"));//true
        System.out.println("****");
        //遍历Map ,Entry 表示"条目" 一个一个的键值对
        //对于Map来说 保存的元素顺序和插入顺序无关
        //Map内部对于元素有自己的规则
        for (Map.Entry<String,String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println("***清空***");
        map.clear();
        System.out.println(map.isEmpty());
        System.out.println(map.size());
    }

    /**
     * Collection
     * @param args
     */
    public static void main1(String[] args) {
        //实例化一个Collection对象,Collection 是一个接口,必须要new 一个对应的类作为实例才可以
        Collection<String> collection = new ArrayList <>();
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
        System.out.println("*********");


        collection.add("hello");
        collection.add("zzn");
        collection.add("drr");
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());

        //String也是继承Object ,array看似是一个Object 数组,其实是String数组
        System.out.println("***********");
        Object[] array = collection.toArray();
        System.out.println(Arrays.toString(array));
        System.out.println(collection);

        //for each 遍历collection
        //比较简单的遍历方式,用while 和 for都需要用到迭代器
        System.out.println("**********");
        for (String s: collection) {
            System.out.println(s);
        }

        //判断元素是否存在(按值比较)
        System.out.println("**********");
        boolean ret = collection.contains("zzn");
        System.out.println(ret);

        //删除指定元素
        System.out.println("*********");
        collection.remove("drr");
        for (String s: collection) {
            System.out.println(s);
        }

        //clear 清空集合
        collection.clear();
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());




    }
}
