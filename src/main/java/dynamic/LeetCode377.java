package dynamic;

import java.util.HashMap;
import java.util.Map;

/*
377. 组合总和 Ⅳ
给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。

示例:

nums = [1, 2, 3]
target = 4

所有可能的组合为：
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

请注意，顺序不同的序列被视作不同的组合。

因此输出为 7。
 */
public class LeetCode377 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(combinationSum40(nums, 4));
    }

    // 状态转移方程是：F(n) = SUM(F(n - nums[i]))
    public static int combinationSum4(int[] nums, int target) {
        int[] res = new int[target + 1];
        res[0] = 1;
        for (int j = 1; j <= target; j ++) {
            for (int i = 0; i < nums.length; i ++) {
                if (j >= nums[i]) {
                    res[j] += res[j - nums[i]];
                }
            }
        }
        return res[target];
    }

    private static Map<Integer, Integer> map = new HashMap<>();
    public static int combinationSum40(int[] nums, int target) {
        if (map.get(target) != null) {
            return map.get(target);
        }
        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count ++;
            }
            if (num < target) {
                count += combinationSum40(nums, target - num);
            }
        }
        map.put(target, count);
        return count;
    }

}
