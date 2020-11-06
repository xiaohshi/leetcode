package dynamic;

/*
376. 摆动序列
如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。

例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。

给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。

示例 1:

输入: [1,7,4,9,2,5]
输出: 6
解释: 整个序列均为摆动序列。
示例 2:

输入: [1,17,5,10,13,15,10,5,16,8]
输出: 7
解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
示例 3:

输入: [1,2,3,4,5,6,7,8,9]
输出: 2
进阶:
你能否用 O(n) 时间复杂度完成此题?
 */
public class LeetCode376 {

    public static void main(String[] args) {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(wiggleMaxLength(nums));
    }

    /*
    对于摆动序列，其元素的差值是正负交错的，该问题可以分为两种：
    一种是最后一个差值为正数，用数组up表示；
    一种是最后一个差值为负数；用数组down表示；
    此时up[i]和down[i]表示对于第i个数其摆动数列的最大长度。
    如果nums[i] - nums[i - 1] > 0表示最后一个差值为正数，其up[i] = down[i - 1] + 1，该式子表示前一个元素为负数差的最大摆动序列长度
    加1；其down[i] = down[i - 1]；
    如果nums[i] - nums[i - 1] < 0表示最后一个差值为负数，其down[i] = up[i - 1] + 1，该式子表示前一个元素为正数差的最大摆动序列长度
    加1，其up[i] = up[i - 1]；
    如果nums[i] - nums[i - 1] = 0两元素保持不变。
     */
    public static int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] - nums[i - 1] > 0) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] - nums[i - 1] < 0) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }

}
