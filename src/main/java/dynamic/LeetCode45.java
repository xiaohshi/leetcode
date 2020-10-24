package dynamic;

import java.util.Arrays;

/*
45. 跳跃游戏 II
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

示例:

输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
public class LeetCode45 {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, nums.length + 1);
        res[0] = 0;
        for (int i = 0; i < len; i ++) {
            for (int j = 1; j <= nums[i]; j ++) {
                if (i + j >= len) {
                    return res[len - 1];
                }
                res[i + j] = Math.min(res[i + j], res[i] + 1);
            }
        }
        return res[len - 1];
    }
}
