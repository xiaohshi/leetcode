package dynamic;

/*
309. 最佳买卖股票时机含冷冻期
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:

输入: [1,2,3,0,2]
输出: 3
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class LeetCode309 {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }

    /*
    价格数组为prices
    定义dp[i]表示第i天的最大利润，在第i天有三种状态，分别是：
    1、持有股票，最大利润记为dp[0][i]，对于i - 1天可能是：
      （1）前一天已经持有股票，则dp[0][i] = dp[0][i - 1]；
      （2）就在当天购买股票，说明前一天一定不持有股票，处于冷冻期，则dp[0][i] = dp[1][i - 1] - price[i];
      则dp[0][i] = max(dp[0][i - 1], dp[1][i - 1] - prices[i])

    2、不持有股票，最大利润记为dp[1][i]，对于i - 1天可能是：
       （1）前一天也不持有股票，则dp[1][i] = dp[1][i - 1];
       （2）前一天将股票卖出，现在是冷冻期，则dp[1][i] = dp[2][i - 1];
       则dp[1][i] = max(dp[1][i - 1], dp[2][i - 1])

    3、不持有股票，最大利润记为dp[2][i]，当天已经将股票卖出，说明前一天肯定有股票
       则dp[2][i] = dp[0][i - 1] + prices[i]

    并且最后一天肯定是不持有股票中最大的一个。
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[3][n];

        dp[0][0] = -prices[0];
        dp[1][0] = 0;
        dp[2][0] = 0;

        for (int i = 1; i < n; i ++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] - prices[i]);
            dp[1][i] = Math.max(dp[1][i - 1], dp[2][i - 1]);
            dp[2][i] = dp[0][i - 1] + prices[i];
        }
        return Math.max(dp[1][n - 1], dp[2][n - 1]);
    }

}
