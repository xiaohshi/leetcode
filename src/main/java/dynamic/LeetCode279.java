package dynamic;

/*
279. 完全平方数
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3
解释: 12 = 4 + 4 + 4.
示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9.
 */
public class LeetCode279 {

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    // 该题就是找零钱那题
    public static int numSquares(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i ++) {
            int m = (int) Math.sqrt(i);
            res[i] = n + 1;
            for (int j = 1; j <= m; j ++) {
                res[i] = Math.min(res[i - j * j] + 1, res[i]);
            }
        }
        return res[n];
    }

}
