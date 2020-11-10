package array;

import java.util.Arrays;

/*
31. 下一个排列
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class LeetCode31 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    /*
    该题找的是字典序中下一个更大的排列，寻找的方法是：
    1、先找出最大的索引 k 满足 nums[k] < nums[k+1]，如果不存在，就翻转整个数组，逆序查找；
    2、再找出另一个最大索引 l 满足 nums[l] > nums[k]，也是逆序查找；
    3、交换 nums[l] 和 nums[k]；
    4、最后翻转 nums[k+1:]。

    举个例子：
    1、比如 nums = [1,2,7,4,3,1]，下一个排列是什么？
    2、我们找到第一个最大索引是 nums[1] = 2
    3、再找到第二个最大索引是 nums[4] = 3
    4、交换，nums = [1,3,7,4,2,1];
    5、翻转，nums = [1,3,1,2,4,7]
    完毕!
     */
    public static void nextPermutation(int[] nums) {
        int k = -1, n = nums.length;
        for (int i = n - 2; i >= 0; i --) {
            if (nums[i] < nums[i + 1]) {
                k = i;
                break;
            }
        }
        if (k == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        int l = -1;
        for (int i = n - 1; i > k; i --) {
            if (nums[i] > nums[k]) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                break;
            }
        }
        reverse(nums, k + 1, n - 1);
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i ++] = nums[j];
            nums[j --] = temp;
        }
    }

}
