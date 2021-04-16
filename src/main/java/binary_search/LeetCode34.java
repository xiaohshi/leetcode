package binary_search;

import java.util.Arrays;

/*
34. 在排序数组中查找元素的第一个和最后一个位置 ★
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。

进阶：

你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？


示例 1：

输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
示例 2：

输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
示例 3：

输入：nums = [], target = 0
输出：[-1,-1]
 */
public class LeetCode34 {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(nums, 7)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int low = helper(nums, target - 0.5);
        int high = helper(nums, target + 0.5);
        if (low == high) {
            return new int[]{-1, -1};
        }
        return new int[]{low, high - 1};
    }

    private static int helper(int[] nums, double target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

}
