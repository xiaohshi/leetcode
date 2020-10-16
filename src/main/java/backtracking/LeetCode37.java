package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
37. 解数独
编写一个程序，通过填充空格来解决数独问题。

一个数独的解法需遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。



一个数独。
答案被标成红色。

提示：

给定的数独序列只包含数字 1-9 和字符 '.' 。
你可以假设给定的数独只有唯一解。
给定数独永远是 9x9 形式的。
 */
public class LeetCode37 {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // visited表示该数独已经填完毕了
    private static boolean visited = false;

    public static void solveSudoku(char[][] board) {
        // 记录每列中的数字出现的情况
        byte[][] rowMap = new byte[9][9];
        // 记录没行中数字出现的情况
        byte[][] colMap = new byte[9][9];
        // 记录3x3中数字出现的情况
        byte[][] threeMap = new byte[9][9];
        // 记录需要填的格子的坐标值
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] != '.') {
                    int n = board[i][j] - '0';
                    // 3x3格子的数量
                    int index = (i / 3) * 3 + j / 3;
                    colMap[i][n - 1] = threeMap[index][n - 1] = 1;
                } else {
                    list.add(new int[]{i, j});
                }
                if (board[j][i] != '.') {
                    int n = board[j][i] - '0';
                    rowMap[i][n - 1] = 1;
                }
            }
        }
        helper(board, list, rowMap, colMap, threeMap, 0);
    }

    private static void helper(char[][] board, List<int[]> list, byte[][] rowMap, byte[][] colMap, byte[][] threeMap, int pos) {
        // 边界条件就是将list集合遍历完
        if (pos == list.size()) {
            visited = true;
            return;
        }
        int[] space = list.get(pos);
        int row = space[0], col = space[1];
        int index = (row / 3) * 3 + col / 3;
        for (int i = 0; i < 9; i ++) {
            if (rowMap[col][i] == 0 && colMap[row][i] == 0 && threeMap[index][i] == 0) {
                board[row][col] = (char) (i + 1 + '0');
                rowMap[col][i] = colMap[row][i] = threeMap[index][i] = 1;
                helper(board, list, rowMap, colMap, threeMap, pos + 1);
                // 当遍历完后不需要进行回退到原来的状态
                if (!visited) {
                    board[row][col] = '.';
                    rowMap[col][i] = colMap[row][i] = threeMap[index][i] = 0;
                }
            }
        }
    }

}
