package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
46. 全排列
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class LeetCode46 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        boolean[] visited = new boolean[nums.length];
        helper(res, nums, visited, new ArrayList<>());
        return res;
    }

    private static void helper(List<List<Integer>> res, int[] nums, boolean[] visited, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                helper(res, nums, visited, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

}
