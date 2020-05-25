package interview;

import java.util.HashMap;
import java.util.Map;

public class Interview {
    public static int singleNumber(int[] nums) {
        //key 是具体的数字, value 是该数字出现的次数
        Map<Integer, Integer> map = new HashMap <>();
        for (int x : nums) {
            Integer count = map.get(x);
            if(count == null) {
                map.put(x, 1);
            }else {
                map.put(x, count + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 3, 3, 4};
        System.out.println(singleNumber(array));
    }
}
