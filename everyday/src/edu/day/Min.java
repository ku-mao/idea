package edu.day;

import java.util.ArrayList;
import java.util.Scanner;

public class Min {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                int n = scanner.nextInt();
                ArrayList<Integer> list = new ArrayList <>();
                int m = 0;
                while (m < n) {
                    list.add(scanner.nextInt());
                    m++;
                }
                for (int i = 1; i < list.size(); i++) {
                    for (int j = 0; j < list.size() - i; j++) {
                        if (list.get(j) > list.get(j + 1)) {
                            int tmp = list.get(j);
                            list.set(j, list.get(j +1));
                            list.set(j + 1, tmp);
                        }
                    }
                }
                for (Integer aList : list) {
                    System.out.print(aList + " ");
                }
                System.out.println();
                int i = 0;
        while (i < list.size()) {
            if (list.get(i) <= 0) {
                i++;
            } else {
                break;
            }
        }
        int k = 1;
        for (int j = i; j < list.size(); j++) {
            if (list.get(j) == k) {
                k++;
            } else {
                System.out.println(k);
                return;
            }
        }
        int size = list.size();
        System.out.println(list.get(size - 1) + 1);
    }
}
