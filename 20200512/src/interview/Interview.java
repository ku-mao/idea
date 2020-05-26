package interview;

import java.util.HashMap;
import java.util.Map;

public class Interview {
    /**
     * 找出只出现一次的数字,其他数字均出现2次
     * @param nums
     * @return
     */
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

    /**
     * 对上面算法的改进
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        int ret = 0;
        for(int x : nums) {
            ret ^= x;
        }
        return ret;
    }

    /**
     * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
     * 找出只出现一次的那两个元素
     * @param nums
     * @return
     */
    public static int[] singleNumber3(int[] nums) {
        int ret = 0;
        for (int x : nums) {
            ret ^= x;
        }

        //找到ret中bit位不为0的那个bit位
        int bit = 0;
        for(; bit < 32; bit++) {
            if((ret & (1 << bit)) > 0) {
                break;
            }
        }
        //此时bit对应的位就是1
        int a = 0;
        int b = 0;
        for (int x : nums) {
            //对数组中的元素按照那个bit是 0 和 不是0 分组
            if ((x & (1 << bit)) > 0) {
                a ^= x;
            } else {
                b ^= x;
            }
        }
        return new int[]{a, b};
    }


    public static void main(String[] args) {
        int[] array = {1, 4, 3, 3, 4};
        System.out.println(singleNumber(array));
        System.out.println(singleNumber2(array));

        int[] array2 = {1, 1, 4, 5, 5, 4, 6, 8};
        int[] ret = singleNumber3(array2);
        for (int x : ret) {
            System.out.print(x + "  ");
        }
    }
}
