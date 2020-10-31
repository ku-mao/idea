package edu.nowcoder;

/**
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 * 最后返回经过上色渲染后的图像。
 * 示例 1:
 * 输入:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析:
 * 在图像的正中间，(坐标(sr,sc)=(1,1)),
 * 在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，
 * 因为它不是在上下左右四个方向上与初始点相连的像素点。
 */
public class 图像渲染 {
    //四个方向的位置更新：顺时针更新
    int[][] nextPosition = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    public void dfs(int[][] image, int row, int col, int[][] book,
                    int sr, int sc, int oldColor, int newColor)
    {
        //处理当前逻辑，修改颜色，并且标记已经修改过了
        image[sr][sc] = newColor;
        book[sr][sc] = 1;
        //遍历每一种可能，四个方向
        for (int k = 0; k < 4; ++k)
        {
            int newSr = sr + nextPosition[k][0];
            int newSc = sc + nextPosition[k][1];
            //判断新位置是否越界
            if (newSr >= row || newSr < 0
                    || newSc >= col || newSc < 0) {
                continue;
            }
           //如果颜色符合要求，并且之前也没有渲染过，则继续渲染
            if (image[newSr][newSc] == oldColor && book[newSr][newSc] == 0)
            {
                dfs(image, row, col, book, newSr, newSc, oldColor, newColor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        int row = image.length;
        int col = image[0].length;
        //建立标记
        int[][] book = new int[row][col];
        dfs(image, row, col, book, sr, sc, oldColor, newColor);
        return image;
    }
}
