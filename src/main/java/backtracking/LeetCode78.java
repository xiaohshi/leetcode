package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
78. 子集
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class LeetCode78 {

    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, 0);
        res.add(new ArrayList<>());
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
        for (int i = start; i < nums.length; i ++) {
            // 这个条件的目的可以”让同一层级，不出现相同的元素；却允许了不同层级之间的重复“，也就是在同一个循环中时候不能重复
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
