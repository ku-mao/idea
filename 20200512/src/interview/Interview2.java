package interview;

import javafx.scene.effect.SepiaTone;

import java.util.*;

public class Interview2 {
    static class Test {
        public ArrayList<Integer> data;

        public Test() {
            data = new ArrayList <>();
        }

        @Override
        public String toString() {
            return "Test{" +
                    "data=" + data +
                    '}';
        }
    }

    public static Test copy(Test t) {
        Test t2 = new Test();
        t2.data = t.data;
        return t2;
    }

    private static Test deepCopy(Test t) {
        Test t2 = new Test();
        t2.data.addAll(t.data);
        return t2;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 给定一个链表，每个节点包含一个额外增加的随机指针
     * 该指针可以指向链表中的任何节点或空节点
     * 要求返回这个链表的 深拷贝
     * @param head
     * @return
     */
    public static Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        //建立新节点与旧结点的关系, 旧节点为key 新节点为value
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        //维护新节点的next和random,此时新节点已存在,只是每个next和random为空
        for (Node cur = head; cur != null; cur = cur.next) {
            Node newCur = map.get(cur);
            newCur.next = map.get(cur.next);
            newCur.random = map.get(cur.random);
        }
        return map.get(head);
    }

    /**
     *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 
     * S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写
     * 因此"a"和"A"是不同类型的石头

     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        //J 是宝石 S 是石头
        int count = 0;

        //遍历S,看S中的字符是否在J 中出现,根据出现情况来计数
        //但是这个方法中String.contains 时间复杂度是O(N) 整体的复杂度是O(N^2)
//        for (int i = 0; i < S.length(); i++) {
//            char c = S.charAt(i);
//            if (J.contains(c + "")) {
//                count++;
//            }
//        }

        //String.contains的时间复杂度是O(N)
        //TreeSet.contains的时间复杂度是O(logN)
        //HashSet.contains的时间复杂度是O(1)
        //改进方法 采用Set.contains

        //把J中的字符放进Set中
        Set<Character> set = new HashSet <>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }

        //再遍历S 判断S中的字符是否在Set中存在
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }




    static class MyComparator implements Comparator<String> {
        private Map<String, Integer> map;

        public MyComparator(Map <String, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(String o1, String o2) {
            int count1 = map.get(o1);
            int count2 = map.get(o2);
            if (count1 == count2) {
                return o1.compareTo(o2);
            }

            return count2 - count1;
        }
    }
    /**
     * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
     * 返回的答案应该按单词出现频率由高到低排序。
     * 如果不同的单词有相同出现频率，按字母顺序排序
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap <>();
        for (String s : words) {
            Integer count = map.getOrDefault(s, 0);
            map.put(s, count + 1);
        }
        //把统计的字符串放在ArrayList里面
        ArrayList<String> arrayList = new ArrayList (map.keySet());
        Collections.sort(arrayList, new MyComparator(map));
        return arrayList.subList(0, k);
    }
    public static void main(String[] args) {
        Test t = new Test();
        t.data.add(1);
        t.data.add(2);
        t.data.add(3);

        Test t2 = copy(t);
        t.data.add(4);
        System.out.println("******浅拷贝******");
        System.out.println(t);
        System.out.println(t2);
        System.out.println("******深拷贝******");
        Test t3 = deepCopy(t);
        t.data.add(5);
        System.out.println(t);
        System.out.println(t3);
    }
}
