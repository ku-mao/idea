package edu.day;



class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}



public class Test {
    /**
     * 子数组最大乘积
     * 给定一个double类型的数组arr，
     * 其中的元素可正可负可0，返回子数组累乘的最大乘积。
     */
    public double maxProduct(double[] arr) {
        //如果arr[i] 为负数, 则最大变最小, 最小变最大
        //最大值是arr[i] 或 arr[i] * max 或 arr[i] * min
        //最小值是arr[i] 或 arr[i] * mix 或 arr[i] * min
        double min = arr[0];
        double max = arr[0];
        double res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            double max1 = max;
            max = Math.max(Math.max(arr[i], arr[i] * max), arr[i] * min);
            min = Math.min(Math.min(arr[i], arr[i] * min), arr[i] * max1);
            res = Math.max(max, res);
        }
        return res;
    }


    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode per = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = per;
            per = head;
            head = next;
        }
        return per;
    }


    /**
     * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
     * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
     */
    public int[] sortArrayByParity(int[] nums) {
        int j = 1;
        for (int i = 0; i < nums.length - 1; i=i+2) {
            if (nums[i] % 2 != 0) {
                while (nums[j] % 2 != 0) {
                    j += 2;
                }
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        return  nums;
    }


    public static void main(String[] args) {
        Test t = new Test();
//        double[] arr = {1.2, 0, 6, 0, -2, -5, 9, 0, 8};
//        System.out.println(t.maxProduct(arr));

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        ListNode newHead = t.reverseList(head);
//        System.out.println(newHead.val);
//        System.out.println(newHead.next.val);
//        System.out.println(newHead.next.next.val);

        int[] arr = {2, 5, 7, 8};
        int[] res = t.sortArrayByParity(arr);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
