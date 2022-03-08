package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
2104. 子数组范围和 ★
给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。
返回 nums 中 所有 子数组范围的 和 。
子数组是数组中一个连续 非空 的元素序列。

示例 1：

输入：nums = [1,2,3]
输出：4
解释：nums 的 6 个子数组如下所示：
[1]，范围 = 最大 - 最小 = 1 - 1 = 0
[2]，范围 = 2 - 2 = 0
[3]，范围 = 3 - 3 = 0
[1,2]，范围 = 2 - 1 = 1
[2,3]，范围 = 3 - 2 = 1
[1,2,3]，范围 = 3 - 1 = 2
所有范围的和是 0 + 0 + 0 + 1 + 1 + 2 = 4

示例 2：

输入：nums = [1,3,3]
输出：4
解释：nums 的 6 个子数组如下所示：
[1]，范围 = 最大 - 最小 = 1 - 1 = 0
[3]，范围 = 3 - 3 = 0
[3]，范围 = 3 - 3 = 0
[1,3]，范围 = 3 - 1 = 2
[3,3]，范围 = 3 - 3 = 0
[1,3,3]，范围 = 3 - 1 = 2
所有范围的和是 0 + 0 + 0 + 2 + 0 + 2 = 4

示例 3：

输入：nums = [4,-2,-3,4,1]
输出：59
解释：nums 中所有子数组范围的和是 59

提示：

1 <= nums.length <= 1000
-109 <= nums[i] <= 109

进阶：你可以设计一种时间复杂度为 O(n) 的解决方案吗？
 */
public class LeetCode2104 {

    public static void main(String[] args) {
        int[] nums = {4,-2,-3,4,1};
        System.out.println(subArrayRanges(nums));
    }

    private static int n;
    public static long subArrayRanges(int[] nums) {
        n = nums.length;
        // min[i] 为 nums[i] 作为区间最小值的次数；max[i] 为 nums[i] 作为区间最大值的次数
        long[] min = getCnt(nums, true), max = getCnt(nums, false);
        long ans = 0;
        for (int i = 0; i < n; i++) ans += (max[i] - min[i]) * nums[i];
        return ans;
    }

    private static long[] getCnt(int[] nums, boolean isMin) {
        int[] a = new int[n], b = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && (isMin ? nums[deque.peekLast()] >= nums[i] : nums[deque.peekLast()] <= nums[i])) {
                deque.pollLast();
            }
            a[i] = deque.isEmpty() ? -1 : deque.peekLast();
            deque.addLast(i);
        }
        deque.clear();
        for (int i = n - 1; i >= 0; i --) {
            while (!deque.isEmpty() && (isMin ? nums[deque.peekLast()] > nums[i] : nums[deque.peekLast()] < nums[i])) {
                deque.pollLast();
            }
            b[i] = deque.isEmpty() ? n : deque.peekLast();
            deque.addLast(i);
        }
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (long) (i - a[i]) * (b[i] - i);
        }
        return ans;
    }
}
