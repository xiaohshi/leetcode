package array;

import java.util.ArrayList;
import java.util.List;

/*
给定一个包含m x n个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例2:

输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]

链接：https://leetcode-cn.com/problems/spiral-matrix
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
            };
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
