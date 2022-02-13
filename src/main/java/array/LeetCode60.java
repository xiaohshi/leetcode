package array;

import java.util.Arrays;

/*
60. 排列序列 ★
给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

示例 1：
输入：n = 3, k = 3
输出："213"

示例 2：
输入：n = 4, k = 9
输出："2314"

示例 3：
输入：n = 3, k = 1
输出："123"

提示：
1 <= n <= 9
1 <= k <= n!
 */
public class LeetCode60 {

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 9));
    }

    /*
    以ai的排列一共有 (n-1)! 个；
    第 k 个排列的首个元素就是：a1 = | k - 1 | / | (n - 1)! | + 1

    以a1开头的最大的元素为a2的排列一共有 (n-2)!(n−2)! 个；
    第k个排列实际就是相当于： k1 = (k - 1) mod (n - 1)!
     */
    public static String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }

        --k;
        StringBuffer ans = new StringBuffer();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; ++i) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    ans.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return ans.toString();
    }

}
