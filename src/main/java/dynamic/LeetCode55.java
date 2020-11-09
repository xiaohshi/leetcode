package dynamic;

/*
55. 跳跃游戏
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class LeetCode55 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }

    // 贪心算法
    public static boolean canJump(int[] nums) {
        int most = 0, n = nums.length;
        for (int i = 0; i < nums.length; i ++) {
            if (i <= most) {
                most = Math.max(most, i + nums[i]);
                if (most >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    // 动态规划
    public static boolean canJump1(int[] nums) {
        int n = nums.length;
        boolean[] res = new boolean[n];
        res[0] = true;
        for (int i = 0; i < n; i ++) {
            if (res[i]) {
                for (int j = 1; j <= nums[i]; j ++) {
                    if (i + j >= n) {
                        return res[n - 1];
                    }
                    res[i + j] = true;
                }
            }
        }
        return res[n - 1];
    }

}
