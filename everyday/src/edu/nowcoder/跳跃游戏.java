package edu.nowcoder;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 */
public class 跳跃游戏 {
    public static void main(String[] args) {
        int[] num = new int[]{2, 4, 1, 1, 4};
        System.out.println(canJump(num));
    }
    private static boolean canJump(int[] nums) {
        int max = 0;//当前可以到达的最远位置下标
        int pos = nums.length - 1;
        for (int i = 0; i <= pos; i++) {
            if (max >= i) {//当前位置可以到达
                //看是否需要更新max值
                max = Math.max(max, i + nums[i]);
            }
            if (max >= pos) {
                return true;
            }
        }
        return false;
    }
}
