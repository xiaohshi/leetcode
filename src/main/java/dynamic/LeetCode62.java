package dynamic;

/*
62. 不同路径
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？

例如，上图是一个7 x 3 的网格。有多少可能的路径？

示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 2:

输入: m = 7, n = 3
输出: 28
 */
public class LeetCode62 {

    public static void main(String[] args) {
        int m = 4, n = 3;

        System.out.println(uniquePaths(m, n));

        int[][] grid = new int[m][n];
        uniquePaths1(grid, m, n, 0, 0);
        System.out.println(count);
    }

    // 就是取对角的之和，动态规划
    public static int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (i == 0 || j == 0) {
                    res[i][j] = 1;
                } else {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }
            }
        }
        return res[m - 1][n - 1];
    }

    // 回溯法
    private static int count = 0;
    private static void uniquePaths1(int[][] grid, int m, int n, int i, int j) {
        if (i >= m || j >= n || grid[i][j] == -1) {
            return;
        }
        if (i == m - 1 && j == n - 1) {
            count ++;
        }
        grid[i][j] = -1;
        uniquePaths1(grid, m, n, i + 1, j);
        uniquePaths1(grid, m, n, i, j + 1);
        grid[i][j] = 0;
    }

}
