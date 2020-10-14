package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
216. 组合总和 III
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：

所有数字都是正整数。
解集不能包含重复的组合。
示例 1:

输入: k = 3, n = 7
输出: [[1,2,4]]
示例 2:

输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class LeetCode216 {

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int k, int n, int start) {
        if (n < 0) {
            return;
        }

        if (list.size() == k && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= 9; i ++) {
            if (i > n) {
                continue;
            }
            list.add(i);
            helper(res, list, k, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
