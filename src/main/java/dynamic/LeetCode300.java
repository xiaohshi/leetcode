package dynamic;

import java.util.ArrayList;
import java.util.List;

/*
300. 最长上升子序列
给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
 */
public class LeetCode300 {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));

        List<List<Integer>> res = new ArrayList<>();
        lengthOfLISPath(res, new ArrayList<>(), nums, 0);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

    /*
    LIS(i)表示第i个数字为结尾的最长上升子序列的长度，表示0到i的范围内，选择数字nums[i]可以获得的最长子序列的长度
    则转移方程为：LIS(i) = max(1 + LIS(j) if nums[i] > nums[j] )
     */
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // 数组并不是上升的
        int[] res = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i ++) {
            res[i] = 1;
            for (int j = 0; j < i; j ++) {
                if (nums[i] > nums[j]) {
                    res[i] = Math.max(res[i], res[j] + 1);
                }
            }
            ans = Math.max(ans, res[i]);
        }
        return ans;
    }

    // 找出最长的子序列
    private static int len = 0;
    private static void lengthOfLISPath(List<List<Integer>> res, List<Integer> list, int[] nums, int cur) {
        if (cur == nums.length) {
            return;
        }
        for (int i = cur; i < nums.length; i ++) {
            if (list.isEmpty() || nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
                if (len <= list.size()) {
                    if (len < list.size()) {
                        res.clear();
                    }
                    len = list.size();
                    res.add(new ArrayList<>(list));
                }
                lengthOfLISPath(res, list, nums, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
