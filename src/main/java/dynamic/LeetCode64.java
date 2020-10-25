package dynamic;

import java.util.ArrayList;
import java.util.List;

/*
64. 最小路径和
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class LeetCode64 {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        List<List<Integer>> res = new ArrayList<>();
        minPath(res, new ArrayList<>(), grid, 0, 0, 0);
        System.out.println(res);

        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (i == 0 && j != 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (j == 0 && i != 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else if (i != 0){
                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    private static int ans = Integer.MAX_VALUE;
    public static void minPath(List<List<Integer>> res, List<Integer> list, int[][] grid, int i, int j, int value) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        list.add(grid[i][j]);
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            if (value < ans) {
                if (res.size() > 0) {
                    res.remove(0);
                }
                ans = value;
                res.add(new ArrayList<>(list));
            }
        }
        minPath(res, list, grid, i + 1, j, value + grid[i][j]);
        minPath(res, list, grid, i, j + 1, value + grid[i][j]);
        list.remove(list.size() - 1);
    }
}
