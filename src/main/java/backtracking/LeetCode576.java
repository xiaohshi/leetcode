package backtracking;

/*
576. 出界的路径数
给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。

给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 109 + 7 取余 后的结果。

示例 1：

输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
输出：6

示例 2：

输入：m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
输出：12

提示：

1 <= m, n <= 50
0 <= maxMove <= 50
0 <= startRow < m
0 <= startColumn < n


https://leetcode-cn.com/problems/out-of-boundary-paths/

 */
public class LeetCode576 {

    public static void main(String[] args) {
        System.out.println(findPaths(2, 2, 2, 0, 0));
        System.out.println(findPaths(1, 3, 3, 0, 1));
        System.out.println(findPaths(2, 3, 8, 1, 0));
    }

    private static int MOD = (int)1e9+7;
    private static int[][][] paths;
    private static int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        paths = new int[m][n][maxMove + 1];
        return helper(startRow, startColumn, maxMove, m, n);
    }

    private static int helper(int i, int j, int move, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 1;
        }
        if (move == 0) {
            return 0;
        }
        if (paths[i][j][move] != 0) {
            return paths[i][j][move];
        }

        // 剪枝：如果小球不管怎么移动都无法越出网格，那就剪掉这个枝
        if (i - move >= 0 && j - move >= 0 && i + move < m && j + move < n) {
            return 0;
        }

        int res = 0;
        for (int[] d : dirs) {
            int nx = i + d[0], ny = j + d[1];
            res += helper(nx, ny, move - 1, m, n);
            res %= MOD;
        }
        paths[i][j][move] = res;
        return res;
    }

}
