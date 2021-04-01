package edu.day;


import java.util.Stack;

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


    /**
     * 一球从100米高度自由落下，
     * 每次落地后反跳回原高度的一半；再落下，
     * 求它在 第10次落地时，共经过多少米？第10次反弹多高？
     */
    public void calc() {
        double sum = 100;
        double num = 100;
        for (int i = 2; i <= 10; i++) {
            num = num / 2;
            sum = sum + num * 2;
        }
        System.out.println("共经过了: " + sum + "米");
        System.out.println("第10次反弹高度: " + (num/2)+ "米");
    }




    public int zuhe() {
        int count = 0;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                for (int k = 1; k < 5; k++) {
                    if (i != j && i != k && j != k) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


    /**
     * 换饮料 3个可换一个
     * @param num
     */
    public int buy(int num) {
        if (num == 0) {
            return 0;
        }
        int total = 0;
        while (num > 2) {
            total = total + num / 3 ;//能够换来的饮料
            num = num / 3 +  num % 3;
        }
        if (num == 2) {
            total = total + 1;
        }
        return total;
    }


   /**
    * 找第K大, 采用快排的思想
     * @param a 数组
     * @param n 数组长度
     * @param K 第K大, 从1开始
     * @return
     */
    public int findKth(int[] a, int n, int K) {
        return find(a, 0, n - 1, K);
    }

    private int find(int[] a, int i, int j, int K) {
        int position = quickSort(a, i, j); //从大到小排
        if (position - i + 1 == K) {
            return a[position];
        } else if (position - i + 1 > K) {
            return find(a, i, position - 1, K);
        } else {
            return find(a, position + 1, j, K - position + i - 1);
        }
    }

    private int quickSort(int[] a, int i, int j) {
        int tmp = a[i];
        while (i < j) {
            while (i < j && a[j] <= tmp) {
                j--;
            }
            a[i] = a[j];
            while (i < j && a[i] >= tmp) {
                i++;
            }
            a[j] = a[i];
        }
        a[i] = tmp;
        return i;
    }


    /**
     * 给定一个字符串A和其长度n，请返回一个bool值代表它是否为一个合法的括号串（只能由括号组成）
     * @param A 數組
     * @param n 數組長度
     * @return
     */
    public boolean chkParenthesis(String A, int n) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
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

//        int[] arr = {2, 5, 7, 8};
//        int[] res = t.sortArrayByParity(arr);
//        for (int i : res) {
//            System.out.print(i + " ");
//        }

//        t.calc();
//        System.out.println(t.zuhe());


//        System.out.println(t.buy(1200));//换汽水

//        int[] a = {2, 8, 6, 3, 9};
//        System.out.println(t.findKth(a, 5, 2));  //寻找第K大的数字


        String str = "(())()";
        System.out.println(t.chkParenthesis(str, 6));
    }
}
