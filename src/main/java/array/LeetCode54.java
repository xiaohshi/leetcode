package array;

import java.util.ArrayList;
import java.util.List;

/*
54. 螺旋矩阵
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

示例 1：
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]

示例 2：
输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]

提示：

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 */
public class LeetCode54 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }

    /*
    利用上下左右边界进行逼近，到循环结束时候，所有的边界都汇聚到中间那个点
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        while (true) {
            for (int i = l; i <= r; i ++) {
                list.add(matrix[t][i]);
            }
            if (++ t > b) {
                break;
            }
            for (int i = t; i <= b; i ++) {
                list.add(matrix[i][r]);
            }
            if (-- r < l) {
                break;
            }
            for (int i = r; i >= l; i --) {
                list.add(matrix[b][i]);
            }
            if (-- b < t) {
                break;
            }
            for (int i = b; i >= t; i --) {
                list.add(matrix[i][l]);
            }
            if (++ l > r) {
                break;
            }
        }
        return list;
    }

}
