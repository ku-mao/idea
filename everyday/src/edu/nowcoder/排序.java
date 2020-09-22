package edu.nowcoder;

public class 排序 {
    public  static int sort (String inData) {
        String[] str = inData.split(" ");
        int[] arr = new int[str.length];
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                count++;
                System.out.println(count);
                int tmp = arr[i];
                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = tmp;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "3 6 2 7";
        System.out.println(sort(str));
    }
}
