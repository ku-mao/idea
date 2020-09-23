package edu.nowcoder;

public class 剧情触发时机 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * func getTriggerTime(increase [][]int, requirements [][]int) []int
     * @param increase int整型二维数组 属性增加值
     * @param requirements int整型二维数组 剧情触发要求
     * @return int整型一维数组
     */
    public int[] getTriggerTime (int[][] increase, int[][] requirements) {
        int[] ret = new int[requirements.length];//存放结果
        for (int n = 0; n < requirements.length; n++) {
            ret[n] = -1;
        }
        int k = 0;
        int[] tmp = new int[3];
        while (k < increase.length) {
            for (int m = 0; m < 3; m++) {
                tmp[m] = increase[k][m];
            }

            for (int i = 0; i < requirements.length; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tmp[0] < requirements[i][0]) {
                        break;
                    }
                    if (tmp[1] < requirements[i][1]) {
                        break;
                    }
                    if (tmp[2] < requirements[i][2]) {
                        break;
                    }
                    ret[i] = k;
                }
            }
            k++;
        }
        return ret;
    }
}
