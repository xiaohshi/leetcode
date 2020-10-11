package array;

/*
304. 二维区域和检索 - 矩阵不可变
给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。

Range Sum Query 2D
上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。

示例:

给定 matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
 */
public class LeetCode304 {

    private static int[][] res, matrix;

    public static void main(String[] args) {
        matrix = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        int m = matrix.length, n = matrix[0].length;
        res = new int[m][n];
        for (int i = 0; i < m; i ++) {
            int sum = 0;
            for (int j = 0; j < n; j ++) {
                sum += matrix[i][j];
                res[i][j] = sum;
            }
        }
        System.out.println(sumRegion(2,1,4,3));
        System.out.println(sumRegion(1,1,2,2));
        System.out.println(sumRegion(1,2,2,4));

    }

    public static int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        for (int i = row1; i <= row2; i ++) {
            sum += (res[i][col2] - res[i][col1] + matrix[i][col1]);
        }
        return sum;
    }

}
