package backtracking;

import java.util.*;

/*
491. 递增子序列
给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。

示例:

输入: [4, 6, 7, 7]
输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
说明:

给定数组的长度不会超过15。
数组中的整数范围是 [-100,100]。
给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 */
public class LeetCode491 {

    public static void main(String[] args) {
        int[] nums = {4 ,3, 2, 1};
        System.out.println(findSubsequences(nums));
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(res, new ArrayList<>(), visited, nums, 0);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, boolean[] visited, int[] nums, int cur) {
        // 用set集合保存同一层的元素防止重复
        Set<Integer> set = new HashSet<>();
        for (int i = cur; i < nums.length; i ++) {
            if (visited[i] || set.contains(nums[i])) {
                continue;
            }
            if (list.isEmpty() || nums[i] >= list.get(list.size() - 1)) {
                visited[i] = true;
                list.add(nums[i]);
                set.add(nums[i]);
                if (list.size() > 1) {
                    res.add(new ArrayList<>(list));
                }
                helper(res, list, visited, nums, i + 1);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

}
