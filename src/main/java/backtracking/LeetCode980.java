package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
980. 不同路径 III
在二维网格 grid 上，有 4 种类型的方格：

1 表示起始方格。且只有一个起始方格。
2 表示结束方格，且只有一个结束方格。
0 表示我们可以走过的空方格。
-1 表示我们无法跨越的障碍。
返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。

每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。



示例 1：

输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
输出：2
解释：我们有以下两条路径：
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)




示例 2：

输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
输出：4
解释：我们有以下四条路径：
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
示例 3：

输入：[[0,1],[2,0]]
输出：0
解释：
没有一条路能完全穿过每一个空的方格一次。
请注意，起始和结束方格可以位于网格中的任意位置。
 */
public class LeetCode980 {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };
        System.out.println(uniquePathsIII(grid));
    }

    public static int uniquePathsIII(int[][] grid) {
        int num = 0, a = 0, b = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    num++;
                } else if (grid[i][j] == 1) {
                    a = i;
                    b = j;
                }
            }
        }
        helper(new ArrayList<>(), grid, a, b, num, 0);
        return res;
    }

    private static int res = 0;
    private static void helper(List<String> ans, int[][] grid, int i, int j, int num, int count) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1 || grid[i][j] == -2) {
            return;
        }
        if (grid[i][j] == 2) {
            if (num == count - 1) {
                res ++;
                StringBuilder s = new StringBuilder();
                for (int a = 0; a < ans.size(); a ++) {
                    if (a == 0) {
                        s.append(ans.get(a));
                    } else {
                        s.append("->").append(ans.get(a));
                    }
                }
                s.append("->").append("(").append(i).append(",").append(j).append(")");
                System.out.println(s.toString());
            }
            return;
        }
        grid[i][j] = -2;
        ans.add("(" + i + "," + j + ")");
        helper(ans, grid, i, j - 1, num, count + 1);
        helper(ans, grid, i, j + 1, num, count + 1);
        helper(ans, grid, i - 1, j, num, count + 1);
        helper(ans, grid, i + 1, j, num, count + 1);
        ans.remove(ans.size() - 1);
        grid[i][j] = 0;
    }

}