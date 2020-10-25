package dynamic;

import java.util.ArrayList;
import java.util.List;

/*
120. 三角形最小路径和
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class LeetCode120 {

    public static void main(String[] args) {
        int[][] nums = {
                {2, 0, 0, 0},
                {3, 4, 0, 0},
                {6, 5, 7, 0},
                {4, 1, 8, 3}
        };
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < 4; i ++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j ++) {
                list.add(nums[i][j]);
            }
            res.add(list);
        }
        System.out.println(minimumTotal(res));
    }

    /*
    状态方程为:
    f[i][j]= f[i−1][0] + c[i][0], j = 0，三角的最左边
             f[i−1][i−1] + c[i][i], j = i，三角的最右边
             min(f[i−1][j−1],f[i−1][j])+c[i][j], other
    由于每一步只能移动到下一行「相邻的节点」上，因此要想走到位置(i, j)，上一步就只能在位置 (i - 1, j - 1)
    或者位置 (i - 1, j)。我们在这两个位置中选择一个路径和较小的来进行转移。

    初始位置为f[0][0]=c[0][0]
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] ans = new int[n];
        ans[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i ++) {
            // tmp用于事先记录下该位置的原来的值，然后将其复制给temp
            int temp = ans[0], tmp = ans[0];
            ans[0] = ans[0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j ++) {
                tmp = ans[j];
                // 此时就相当于上一层对应的两个值
                ans[j] = Math.min(temp, ans[j]) + triangle.get(i).get(j);
                temp = tmp;
            }
            ans[i] = temp + triangle.get(i).get(i);
        }
        int res = ans[0];
        for (int num : ans) {
            res = Math.min(res, num);
        }
        return res;
    }

}
