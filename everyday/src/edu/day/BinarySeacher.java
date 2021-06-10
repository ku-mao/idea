package edu.day;

import java.util.Scanner;


public class BinarySeacher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int t = scanner.nextInt();
        System.out.println(search(arr, t));
    }

    public static  int search (int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                while (mid != 0 && nums[mid] == nums[mid - 1]) {
                    mid--;
                }
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
