package array;

/*
41. 缺失的第一个正数
给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。



示例 1:

输入: [1,2,0]
输出: 3
示例 2:

输入: [3,4,-1,1]
输出: 2
示例 3:

输入: [7,8,9,11,12]
输出: 1


提示：

你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 */
public class LeetCode41 {

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(firstMissingPositive(nums));
    }

    /*
    1、在该数组中最小的正整数范围为[1,n+1],首先先判断数组中是否有1，没有就直接返回1；
    2、如果数组中的数字小于等于0或者大于数组的长度的数就将该位置变为1；
    3、遍历数组，读到数字a的时候，给a-1位置的元素加上负号，并且只改变一次符号
     */
    public static int firstMissingPositive(int[] nums) {
        boolean flag = false;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 1) {
                flag = true;
            }
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }
        if (!flag) {
            return 1;
        }
        for (int i = 0; i < nums.length; i ++) {
            int index = Math.abs(nums[i]);
            if (nums[index - 1] > 0) {
                nums[index - 1] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

}
