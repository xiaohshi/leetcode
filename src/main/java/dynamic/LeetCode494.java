package dynamic;

import java.util.ArrayList;
import java.util.List;

/*
494. 目标和
给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

返回可以使最终数组和为目标数 S 的所有添加符号的方法数。

示例：

输入：nums: [1, 1, 1, 1, 1], S: 3
输出：5
解释：

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

一共有5种方法让最终目标和为3。

提示：

数组非空，且长度不会超过 20 。
初始的数组的和不会超过 1000 。
保证返回的最终结果能被 32 位整数存下。
 */
public class LeetCode494 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(nums, 3));

        List<String> res = new ArrayList<>();
        findTargetSumWaysPath(res, "", nums, 0, 3, 0);
        for (String s : res) {
            System.out.println(s);
        }
    }

    /*
    根据该问题描述，我们可以得知，在这个数组nums中，有m个数是正数，有n个数是负数，m + n = nums.length
    则m个数的和为x，n个数的和为y，则x + y = 数组的和sum，x - y = 目标值S，则x = (S + sum) / 2;
    此时这个问题就可以转化为，有多少种方式可以使用数组中的和为x，其中每一个元素只能使用一次。
     */
    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + S) % 2 != 0) {
            return 0;
        }
        int x = (sum + S) / 2;
        int[] res = new int[x + 1];
        res[0] = 1;
        for (int i = 0; i < nums.length; i ++) {
            for (int j = x; j >= nums[i]; j --) {
                res[j] += res[j - nums[i]];
            }
        }
        return res[x];
    }

    // 找出所有的结果, 利用回溯法
    public static void findTargetSumWaysPath(List<String> res, String s, int[] nums, int ans, int S, int cur) {
        if (cur >= nums.length) {
            if (ans == S) {
                res.add(s);
            }
            return;
        }
        if (cur == 0) {
            findTargetSumWaysPath(res, s + "+" + nums[cur], nums, nums[cur], S, cur + 1);
            findTargetSumWaysPath(res, s + "-" + nums[cur], nums, - nums[cur], S, cur + 1);
        } else {
            findTargetSumWaysPath(res, s + "+" + nums[cur], nums, ans + nums[cur], S, cur + 1);
            findTargetSumWaysPath(res, s + "-" + nums[cur], nums, ans - nums[cur], S, cur + 1);
        }
    }

}
