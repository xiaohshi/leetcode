package dynamic;

/*
688. 骑士在棋盘上的概率
在一个 n x n 的国际象棋棋盘上，一个骑士从单元格 (row, column) 开始，并尝试进行 k 次移动。行和列是 从 0 开始 的，所以左上单元格是 (0,0) ，右下单元格是 (n - 1, n - 1) 。

象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。
每次骑士要移动时，它都会随机从8种可能的移动中选择一种(即使棋子会离开棋盘)，然后移动到那里。
骑士继续移动，直到它走了 k 步或离开了棋盘。

返回 骑士在棋盘停止移动后仍留在棋盘上的概率 。

示例 1：
输入: n = 3, k = 2, row = 0, column = 0
输出: 0.0625
解释: 有两步(到(1,2)，(2,1))可以让骑士留在棋盘上。
在每一个位置上，也有两种移动可以让骑士留在棋盘上。
骑士留在棋盘上的总概率是0.0625。

示例 2：
输入: n = 1, k = 0, row = 0, column = 0
输出: 1.00000

提示:

1 <= n <= 25
0 <= k <= 100
0 <= row, column <= n
 */
public class LeetCode688 {

    public static void main(String[] args) {
        System.out.println(knightProbability(3, 2, 0, 0));

        System.out.println(knightProbability1(3, 2, 0, 0));
    }

    private static int[][] steps = {{1, 2}, {-1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, -2}, {-2, -1}, {-2, 1}};

    // 利用dfs进行回溯处理
    public static double knightProbability(int n, int k, int row, int column) {
        double[][][] mems = new double[n][n][k + 1];
        return helper(n, k, row, column, mems);
    }

    // 在回溯的过程中进行记忆，保存(i,j,k)还在棋盘中的概率
    private static double helper(int n, int k, int row, int column, double[][][] mems) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (mems[row][column][k] != 0) {
            return mems[row][column][k];
        }
        double res = 0;
        for (int[] step : steps) {
            res += helper(n, k - 1, row + step[0], column + step[1], mems) / 8.0;
        }
        mems[row][column][k] = res;
        return res;
    }

    /*
    动态规划，假设概率是f(x, y, k)
    相当于上一步的概率/8, 其概率就是：f(x, y, k) = ∑f(xn, yn, k - 1) / 8;

     */
    public static double knightProbability1(int n, int k, int row, int column) {
        double[][][] mems = new double[n][n][k + 1];

        for (int a = 0; a <= k; a ++) {
            for (int b = 0; b < n; b ++) {
                for (int c = 0; c < n; c ++) {
                    if (a == 0) {
                        mems[b][c][a] = 1;
                    } else {
                        for (int[] step : steps) {
                            int x = b + step[0], y = c + step[1];
                            if (x < 0 || y < 0 || x >= n || y >= n) {
                                continue;
                            }
                            mems[b][c][a] += mems[x][y][a - 1] / 8.0;
                        }
                    }
                }
            }
        }
        return mems[row][column][k];
    }


}
