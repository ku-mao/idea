package edu;

import java.util.Arrays;
import java.util.Scanner;

public class Merge {
    public static void main(String[] args) {
        int[] nums1 = {4,6,8};
        int [] nums2 = {2,3,6};
        int n = nums1.length;
        int m = nums2.length;

//       merge1(nums1 , m , nums2 , n);
//       merge2(nums1 , m , nums2 , n);
//       merge3(nums1 , m , nums2 , n);

    }

    /**
     *system,arraycopy(a,b,c,d,e);
     * a参数:表示要复制的数组
     * b参数:数组1要开始复制的位置
     * c参数:新的数组2
     * d参数:从2数组的第d个位置开始拼接
     * e参数:要从1数组中抽取e个元素
     */

    /**
     *先合并，再排序
     * 时间复杂度 : O((n+m)log(n+m))
     * 空间复杂度 : O(1)
     */
    public  static void merge1(int[] nums1, int m, int[] nums2, int n) {
      System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }

    /**
     * 双指针/从前到后排序
     * 时间复杂度 ： O(m+n)
     *空间复杂度 ： O(m)
     */
    public  static void merge2(int[] nums1, int m, int[] nums2, int n) {
        // 先复制数组nums1
        int [] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        int p1 = 0;//nums1_copy的指针
        int p2 = 0;//nums2的指针
        int p = 0;  //nums1的指针

        // 比较 nums1_copy 和 nums2 的元素
        // 把较小的放在nums1中
        while ((p1 < m) && (p2 < n))
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

        // 还有数组未添加进nums1中，进行合并
        if (p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }


    /**
     *双指针/从后到前排序
     * 时间复杂度 ： O(m+n)
     * 空间复杂度 ： O(1)
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
    //
    int p1 = m - 1;//nums1的指针
    int p2 = n - 1;//nums2的指针
    int p = m + n - 1;// 因为nums1数组的长度很长 是合并后的指针

   //比较两个数组的元素，把较大的添加到nums1的后面
    while ((p1 >= 0) && (p2 >= 0))
    // compare two elements from nums1 and nums2
    // and add the largest one in nums1
    nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

    // 如果num2有剩余元素，添加到nums1的开头，剩余的个数为p2+1
    System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
}
}
