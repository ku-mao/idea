package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
