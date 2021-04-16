package dynamic;

import java.util.*;

/*
416. 分割等和子集
给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意:

每个数组中的元素不会超过 100
数组的大小不会超过 200
示例 1:

输入: [1, 5, 11, 5]

输出: true

解释: 数组可以分割成 [1, 5, 5] 和 [11].


示例 2:

输入: [1, 2, 3, 5]

输出: false

解释: 数组不能分割成两个元素和相等的子集.
 */
public class LeetCode416 {

    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 7, 5};
        System.out.println(canPartition(nums));

        System.out.println(res);
    }

    /*
    典型的背包问题，在n个物品中选择一定的物品，填满sum/2的背包
    F(n, c)考虑将n个物品填满容量为c的背包
    状态转移方程为：F(i, c) = F(i - 1, c) || F(i - 1, c - w(i))
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int c = sum / 2;
        boolean[] res = new boolean[c + 1];
        res[0] = true;
        for (int i = 1; i < n; i ++) {
            for (int j = c; j >= nums[i]; j --) {
                res[j] = res[j] || res[j - nums[i]];
            }
        }
        Arrays.sort(nums);
        canPartitionPath(new ArrayList<>(), nums, c, 0);
        return res[c];
    }

    // 找出划分的组合
    private static List<List<Integer>> res = new ArrayList<>();
    // 利用递归法，记忆化搜索
    public static void canPartitionPath(List<Integer> list, int[] nums, int sum, int start) {
        if (sum == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum < 0) {
            return;
        }
        for (int i = start; i < nums.length; i ++) {
            if (nums[i] > sum) {
                break;
            }
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            canPartitionPath(list, nums, sum - nums[i], i + 1);
            list.remove(list.size() - 1);
        }
    }

    // 利用递归法，记忆化搜索
    public static boolean canPartition1(int[] nums) {
        int sum = 0, n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        return helper(nums, n - 1, sum / 2);
    }

    private static Map<String, Boolean> map = new HashMap<>();
    private static boolean helper(int[] nums, int i, int sum) {
        String key = i + " " + sum;
        if (map.get(key) != null) {
            return map.get(key);
        }
        if (sum == 0) {
            return true;
        }
        if (i < 0 || sum < 0) {
            return false;
        }
        boolean res = helper(nums, i - 1, sum) || helper(nums, i - 1, sum - nums[i]);
        map.put(key, res);
        return res;
    }
}
