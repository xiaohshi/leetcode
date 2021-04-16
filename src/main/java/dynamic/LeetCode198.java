package dynamic;

/*
198. 打家劫舍
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

示例 1：

输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 2：

输入：[2,7,9,3,1]
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。

提示：

0 <= nums.length <= 100
0 <= nums[i] <= 400
 */
public class LeetCode198 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }

    /*
    首先划分子问题，对于前k个房间找出最大的
    1、如果第k个房间不拿，那么就是前k-1中最大的；
    2、如果拿了第k个房间，那么就是nums[k]加上k-2最大的
    就取以上两个最大的
     */
    public static int rob(int[] nums) {
        int[] res = new int[nums.length + 1];
        res[0] = 0;
        res[1] = nums[0];
        for (int i = 2; i < res.length; i ++) {
            res[i] = Math.max(res[i - 1], nums[i - 1] + res[i - 2]);
        }
        return res[nums.length];
    }

}
