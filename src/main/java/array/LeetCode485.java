package array;

/*
485. 最大连续1的个数
给定一个二进制数组， 计算其中最大连续1的个数。

示例 1:

输入: [1,1,0,1,1,1]
输出: 3
解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 */

public class LeetCode485 {

    public static void main(String[] args) {
        int[] a = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(a));
    }

    // 一次遍历找出1的个数，并进行统计，遇到0就进行最大最的判断
    public static int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 0, count = 0;
        for (int i = 0; i < nums.length - 1; i ++) {
            if (nums[i] == 1) {
                count ++;
                if (nums[i + 1] != 1) {
                    max = Math.max(max, count);
                    count = 0;
                }
            }
        }
        if (nums[nums.length - 1] == 1) {
            count ++;
            max = Math.max(max, count);
        }
        return max;
    }
}
