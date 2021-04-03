package edu.day;

public class OnlyNum {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 2, 2, 7, 5, 3};
        //找出数组中只出现1次的2个数字
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res ^= arr[i];
        }

        //res 此时是要找的两个数的异或结果
        //异或的结果里面, 比特位为1的位置肯定是2个数字比特位不一样的位置
        //根据此特性对数组里面的数字进行分组

        //先找到那个比特位为1的位置, 从低往高找
        int flag = 1;
        int size = Integer.SIZE;
        for (int i = 0; i < size; i++) {
            if ((flag & res) == 0) {
                flag = flag << 1;
            } else  {
                break;
            }
        }
        //分组
        for (int i = 0; i < arr.length; i++) {
            if ((flag & arr[i]) == 0) {
                num1[0] ^= arr[i];
            }else {
                num2[0] ^= arr[i];
            }
        }
        System.out.println(num1[0] + " " + num2[0]);
    }
}
