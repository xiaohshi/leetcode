package array;

/*
238. 除自身以外数组的乘积
给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。



示例:

输入: [1,2,3,4]
输出: [24,12,8,6]


提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。

说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

进阶：
你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class LeetCode238 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] res = productExceptSelf(nums);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        res[0] = 1;
        for (int i = 1; i < n; i ++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        // 利用right保存右边的值
        // 刚开始右边没有元素，所以 R = 1
        int right = 1;
        // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
        for (int i = n - 1; i >= 0; i --) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            res[i] = res[i] * right;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            right *= nums[i];
        }
        return res;
    }

}
