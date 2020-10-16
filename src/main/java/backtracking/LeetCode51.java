package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
51. N 皇后
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

示例：

输入：4
输出：[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。
 */
public class LeetCode51 {

    public static void main(String[] args) {
        long cur = System.currentTimeMillis();
        System.out.println(solveNQueens(10));
        System.out.println(System.currentTimeMillis() - cur);
    }

    // 就是在判断一个位置所在的列和两条对角线是否有皇后
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        // 记录某一列是否放置了皇后
        Set<Integer> col = new HashSet<>();
        // 记录对角线上单元格是否放置了皇后，在该对角线上下标差相等
        Set<Integer> sub = new HashSet<>();
        // 记录副对角线单元格是否放置了皇后，在该对角线上下标和相等
        Set<Integer> main = new HashSet<>();
        helper(res, col, sub, main, new ArrayList<>(), n, 0);
        return res;
    }

    private static void helper(List<List<String>> res, Set<Integer> col, Set<Integer> sub, Set<Integer> main, List<Integer> path, int n, int row) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int num : path) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i ++) {
                    if (i == num) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }

        // 在回溯的时候是一行的一个位置一个位置的进行找，所有不可能有两个皇后在同一行上
        for (int i = 0; i < n; i ++) {
            if (!col.contains(i) && !sub.contains(i - row) && !main.contains(i + row)) {
                path.add(i);
                col.add(i);
                sub.add(i - row);
                main.add(i + row);

                helper(res, col, sub, main, path, n, row + 1);

                path.remove(path.size() - 1);
                col.remove(i);
                sub.remove(i - row);
                main.remove(i + row);
            }
        }
    }

}
