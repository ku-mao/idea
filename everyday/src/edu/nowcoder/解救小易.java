package edu.nowcoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 解救小易 {
    public static void main(String[] agrs) throws Exception{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String str = br.readLine();
        int num = Integer.parseInt(str);
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        int[] x = new int[num];
        int[] y = new int[num];
        for(int i = 0; i < num; i++){
            x[i] = Integer.parseInt(s1[i]);
            y[i] = Integer.parseInt(s2[i]);
        }
        int min = x[0] - 1 + y[0] - 1;
        for(int i = 1; i < num; i++){
            int temp = x[i] - 1 + y[i] - 1;
            if(temp < min){
                min = temp;
            }
        }
        System.out.print(min);
    }
}
